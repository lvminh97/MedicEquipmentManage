<?php
if(!defined('__CONTROLLER__')) define('__CONTROLLER__', 'true');
require_once "Model/Account.php";
require_once "Model/Equipment.php";
require_once "Model/History.php";

class Controller{
    protected $accountObj;
    protected $equipmentObj;
    protected $historyObj;

    public function __construct(){
        $this->accountObj = new Account;
        $this->equipmentObj = new Equipment;
        $this->historyObj = new History;
        sessionInit();
        setTimeZone();
    }
}
?>