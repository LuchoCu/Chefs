var URL_LOGIN = "/login";
var URL_LOGOUT = "/logout";
var URL_T_CHEFS = "/tchefs";
var URL_T_MEALS = "/tmeals";

var USR_ID = 0;

function f_more_chefs() {

    $("#top_meals_menu").hide();
    $.ajax({
        method: 'GET',
        url: URL_T_CHEFS,
        contentType: "application/json; charset=utf-8",
        success: function(result){
            alert("[Top Chefs] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            alert("[Top Chefs] Error: " + error);
        }
    });
    $("#b_more_chefs").hide();
}

function f_more_meals() {

    $("#top_chefs_menu").hide();
    $.ajax({
        method: 'GET',
        url: URL_T_MEALS + "/10",
        contentType: "application/json; charset=utf-8",
        success: function(result){
            alert("[Top Meals] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            alert("[Top Meals] Error: " + error);
        }
    });
    $("#b_more_meals").hide();
}

function f_start() {

    if(USR_ID === 0){
        window.location.reload(true);
    }
    var top_ten_chefs;
    var top_ten_meals;

    $("#start_menu").show();
    $("#menu_panel").show();
    $("#top_chefs_menu").show();
    $("#b_more_chefs").show();
    $("#top_meals_menu").show();
    $("#b_more_meals").show();
    $.ajax({
        method: 'GET',
        url: URL_T_CHEFS + "/10",
        contentType: "application/json; charset=utf-8",
        success: function(result){
            alert("[Top Chefs] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            alert("[Top Chefs] Error: " + error);
        }
    });
    $.ajax({
        method: 'GET',
        url: URL_T_MEALS + "/10",
        contentType: "application/json; charset=utf-8",
        success: function(result){
            alert("[Top Meals] Result " + JSON.stringify(result));
        },

        error: function(request, status, error){
            alert("[Top Meals] Error: " + error);
        }
    });
}

function f_login() {

    var email = $("#email").val();
    var password = $("#password").val();
    console.log("[Login] Email " + email);
    console.log("[Login] Passw " + password);

    $.ajax({
        method: 'POST',
        url: URL_LOGIN,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify({"email": email, "password": password}),

        success: function(result){
            console.log("[Login] Result " + JSON.stringify(result));

            USR_ID = result.usr_id;
            $("#login_menu").hide();
            f_start();
        },

        error: function(request, status, error){
            console.log("[Login] Error: " + error);
        }
    });
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
});
