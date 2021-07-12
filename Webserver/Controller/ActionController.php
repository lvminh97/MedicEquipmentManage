<?php
require_once "Controller.php";
class ActionController extends Controller{

    public function __construct(){
        parent::__construct();
    }

    public function login($loginData){
        $loginResp = $this->accountObj->login($loginData['username'], _hash($loginData['password']));
        $check = json_decode($loginResp);
        if($check->status == "OK"){
            nextpage("./.");
        }
    }

    public function logout(){
        $this->accountObj->logout();
        nextpage("./.");
    }
}
?>