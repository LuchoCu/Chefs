/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author Luis Ignacio Cubero
 */
public class Mongo {
    
    MongoClient mongo = new MongoClient( "MiniOptimus" , 27017 );
  //MongoClient mongo = new MongoClient( "localhost" , 27017 );  ---ESTOOOO
    MongoDatabase db = mongo.getDatabase("Chefs");
    
    public void insertarFactura(Factura entity )
    {
        MongoCollection table = db. getCollection("Factura");
        Document document = new Document();
        document.put("id", entity.getId().toString());
        document.put("pedido_id", entity.getPedidoId().toString());
        document.put("monto", entity.getMonto().toString());
        document.put("fecha", entity.getFecha().toString());
        table.insertOne(document);
    }
    
    public void verFactura(BigDecimal id) throws FileNotFoundException, IOException
    {
        MongoCollection table = db. getCollection("Factura");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", String.valueOf(id));
        FindIterable cursor = table.find(searchQuery);
    }
     
    public void insertarAccion(String accion)
    {
        MongoCollection table = db. getCollection("Acciones");
        Document document = new Document();
        document.put("Hora", Date.from(Instant.now()).toString());
        document.put("Accion", accion);
        table.insertOne(document);
    }
    
    public String verAccion()
    {
        MongoCollection table = db. getCollection("Acciones");
        MongoCursor<Document> cursor = table.find().iterator();
        BasicDBList list = new BasicDBList();
        while(cursor.hasNext())
        {
            Document doc = cursor.next();
            list.add(doc);
        }
        return JSON.serialize(list);
    }
}
