var URL_LOGIN = "/login";
var URL_LOGOUT = "/logout";
var URL_TOP_CHEFS = "/top/chefs/";
var URL_TOP_MEALS = "/top/meals/";
var URL_CHEFS = "/chefs/";
var URL_MEALS = "/meals/";
var URL_CHEFS_MEALS = "/chefs/meals/";
var URL_RATE = "/rate/chefs/";
var URL_CHEFS_COMMENTS = "/comments/chefs/";
var URL_MEALS_COMMENTS = "/comments/meals/";


var USR_ID = 0;

function rateChef(id, star) {
    alert(star);
    $.ajax({
        method: 'POST',
        url: URL_RATE + id,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"rate" : star, "USR_ID" : USR_ID}),

        success: function(result){
            console.log("[Login] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            console.log("[Login] Error: " + error);
        }
    });
}

function rateMeal(id, star) {

}

function getChefMeal() {

}

function getChef() {
    $("#top_chefs_menu").hide();
    $("#top_meals_menu").hide();
    $("#chef_menu").show();
    $("#chef_menu #info").empty();
    $("#chef_menu #elements").empty();
    id = $(this).attr("id")
    $("#chef_menu").attr("chefId", id);
    $.ajax({
        method: 'GET',
        url: URL_CHEFS + id,
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            //alert(JSON.stringify(result));
            $("#chef_menu #info").append("<img src=\"chef.png\">");
            $("#chef_menu #info").append("<p>" + result.name + "</p>");
            $("#chef_menu #info").append("<p>" + result.email + "</p>");
        },

        error: function(request, status, error){
            alert("[Top Chefs] Error: " + error);
        }
    });
    page = $("#chef_menu #b_more_comments").attr("page");
    page++;

    $.ajax({
        method: 'GET',
        url: URL_CHEFS_COMMENTS + id + "/" + page,
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            elements = result.elements;
            for (i in elements) {
                $("#chef_menu #elements").append("<p>" + elements[i].name + "</p>");
                $("#chef_menu #elements").append("<p>" + elements[i].comment + "</p>");
            }

        },

        error: function(request, status, error){
            alert("[Top Chefs] Error: " + error);
        }
    });
    $("#chef_menu #b_more_comments").attr("page", page);

}

function getMeal() {

}

function chefs() {
    page = $("#b_more_chefs").attr("page");
    page++;

    $.ajax({
        method: 'GET',
        url: URL_TOP_CHEFS + page,
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            elements = result.elements;
            for (i in elements) {

                $("#top_chefs_menu #elements").append("<div id=\"" + elements[i].id + "\" class=\"chef click\">");
                $("#" + elements[i].id).append("<img src=\"chef.png\">");
                $("#" + elements[i].id).append("<p>" + elements[i].name + "</p>");

                n = 5;
                rating = Math.round(elements[i].rating);
                while (rating--) {
                    n--;
                    $("#" + elements[i].id).append("<img src=\"fullStar.png\">");
                }
                while (n--) {
                    $("#" + elements[i].id).append("<img src=\"emptyStar.png\">");
                }
            }
            $(".chef").click(getChef);
        },

        error: function(request, status, error){
            alert("[Top Chefs] Error: " + error);
        }
    });
    $("#b_more_chefs").attr("page", page);
}

function meals() {
    page = $("#b_more_meals").attr("page");
    page++;

    $.ajax({
        method: 'GET',
        url: URL_TOP_MEALS + page,
        contentType: "application/json; charset=utf-8",
        success: function(result){
            //alert("[Top Meals] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            alert("[Top Meals] Error: " + error);
        }
    });

    $("#b_more_meals").attr("page", page);
}

function f_more_chefs() {

    $("#top_meals_menu").hide();
    chefs();
}

function f_more_meals() {

    $("#top_chefs_menu").hide();
    meals();
}

function f_start() {
    if (USR_ID === 0) {
        window.location.reload(true);

    } else {

        var top_ten_chefs;
        var top_ten_meals;

        $("#start_menu").show();
        $("#menu_panel").show();
        $("#top_chefs_menu").show();
        $("#b_more_chefs").show();
        $("#top_meals_menu").show();
        $("#b_more_meals").show();
        $("#b_more_chefs").attr("page", 0);
        $("#b_more_meals").attr("page", 0);
        $("#top_chefs_menu #elements").empty();
        $("#top_meals_menu #elements").empty();

        chefs();
        meals();
    }
}

function f_login() {

    var email = $("#email").val();
    var password = $("#password").val();
    console.log("[Login] Email " + email);
    console.log("[Login] Passw " + password);
    if (email && password) {

        $.ajax({
            method: 'POST',
            url: URL_LOGIN,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify({"email": email, "password": password}),

            success: function(result){
                console.log("[Login] Result " + JSON.stringify(result));

                if (result.status === "OK") {
                    USR_ID = result.usr_id;
                    $("#login_menu").hide();
                    f_start();

                } else {
                    $("#error_login").show();
                }
            },

            error: function(request, status, error){
                console.log("[Login] Error: " + error);
            }
        });
    } else {
        $("#error_login").show();
    }
}

function f_logout() {

    $.ajax({
        method: 'POST',
        url: URL_LOGOUT,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"usr_id":USR_ID}),

        success: function(result){
            console.log("[Logout] Result " + JSON.stringify(result));
            window.location.reload(true);
        },

        error: function(request, status, error){
            console.log("[Logout] Error: " + error);
        }
    });
}

$(document).ready(function(){

    $("#logo_image").click(f_start);
    $("#b_loguin").click(f_login);
    $("#b_logout").click(f_logout);
    $("#b_more_chefs").click(f_more_chefs);
    $("#b_more_meals").click(f_more_meals);
    $("#chef_menu #star1").click(function() {
        id = $("#chef_menu").attr("chefid");
        rateChef(id, 1);
    });
    $("#chef_menu #star2").click(function() {
        id = $("#chef_menu").attr("chefid");
        rateChef(id, 2);
    });
    $("#chef_menu #star3").click(function() {
        id = $("#chef_menu").attr("chefid");
        rateChef(id, 3);
    });
    $("#chef_menu #star4").click(function() {
        id = $("#chef_menu").attr("chefid");
        rateChef(id, 4);
    });
    $("#chef_menu #star5").click(function() {
        id = $("#chef_menu").attr("chefid");
        rateChef(id, 5);
    });

    $("#meal_menu #star1").click(function() {
        id = $("#meal_menu").attr("mealid");
        rateMeal(id, 1);
    });
    $("#meal_menu #star2").click(function() {
        id = $("#meal_menu").attr("mealid");
        rateMeal(id, 2);
    });
    $("#meal_menu #star3").click(function() {
        id = $("#meal_menu").attr("mealid");
        rateMeal(id, 3);
    });
    $("#meal_menu #star4").click(function() {
        id = $("#meal_menu").attr("mealid");
        rateMeal(id, 4);
    });
    $("#meal_menu #star5").click(function() {
        id = $("#meal_menu").attr("mealid");
        rateMeal(id, 5);
    });
    
});
