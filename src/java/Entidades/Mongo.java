/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 *
 * @author Luis Ignacio Cubero
 */
public class Mongo {
    
    public void insertarMongo(Factura entity )
    {
        MongoClient mongo = new MongoClient( "MiniOptimus" , 27017 );
        //MongoClient mongo = new MongoClient( "localhost" , 27017 );  ---ESTOOOO
        DB db = (DB) mongo.getDatabase("Chefs");
        DBCollection table = db.getCollection("Factura");
        BasicDBObject document = new BasicDBObject();
        document.put("id", entity.getId().toString());
        document.put("pedido_id", entity.getPedidoId().toString());
        document.put("monto", entity.getMonto().toString());
        document.put("fecha", entity.getFecha().toString());
        table.insert(document);
    }
    
    public void verMongo(BigDecimal id) throws FileNotFoundException, IOException
    {
        MongoClient mongo = new MongoClient( "MiniOptimus" , 27017 );
        //MongoClient mongo = new MongoClient( "localhost" , 27017 );  ---ESTOOOO
        DB db = new DB(mongo, "Chefs");
        DBCollection table = db.getCollection("Factura");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id", String.valueOf(id));
        DBCursor cursor = table.find(searchQuery);


        File f = new File("source.htm");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html>");
        bw.write("<body>");
        bw.write("<h1>ShowGeneratedHtml source</h1>");
        bw.write("<textarea cols=75 rows=30>");

        String line;
        while (cursor.hasNext()) {
            bw.write(cursor.next().toString());
            bw.newLine();
        }

        bw.write("</text" + "area>");
        bw.write("</body>");
        bw.write("</html>");

        bw.close();

        Desktop.getDesktop().browse(f.toURI());
    }
        
}
