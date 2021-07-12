<?php
    require_once "Controller/Route.php";
    $route = new Route("ViewController@getEquipment");

    // API for app
    $route->get("action", "app-login-act", "ApiController@login");
    $route->get("action", "app-add-equipment-act", "ApiController@addEquipment");
    $route->get("action", "app-get-equipment-list-act", "ApiController@getEquipmentList");
    $route->get("action", 'app-get-equipment-act', "ApiController@getEquipment");
    $route->get("action", "app-update-equipment-act", "ApiController@updateEquipment");
    $route->get("action", "app-delete-equipment-act", "ApiController@deleteEquipment");
    $route->get("action", "app-add-history-act", "ApiController@addHistory");
    $route->get("action", "app-search-act", "ApiController@search");

    // Web
    $route->post("action", "loginAct", "ActionController@login");
    $route->get("link", "equipment", "ViewController@getEquipment");
    $route->get("action", "get-history-list-act", "ViewController@getHistoryList");
    $route->get("action", "logout", "ActionController@logout");
    $route->process();
?>