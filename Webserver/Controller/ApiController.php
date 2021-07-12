<?php
require_once "Controller.php";
class ApiController extends Controller{

    public function __construct(){
        parent::__construct();
    }

    public function login(){
        $data = json_decode($_GET['data']);
        $loginResp = $this->accountObj->login($data->user, _hash($data->pass), "app");
        echo $loginResp;
    }

    public function addEquipment(){
        $data = json_decode($_GET['data']);
        $this->equipmentObj->addItem($data);
        $this->historyObj->addItem($data);
        echo "AddNewEquipmentOK";
    }

    public function getEquipmentList(){
        $list = $this->equipmentObj->getList("1", "id");
        for($i = 0; $i < count($list); $i++){
            $checkNumber = $this->historyObj->getList("equip_id='{$list[$i]['id']}'", "time");
            $number = 0;
            foreach($checkNumber as $checkNumberItem){
                if($checkNumberItem['in_out'] == "in") $number += $checkNumberItem['number'];
                else $number -= $checkNumberItem['number'];
            }
            $list[$i]['number'] = $number;
        }
        echo json_encode($list);
    }

    public function getEquipment(){
        $id = $_GET['id'];
        $item = $this->equipmentObj->getItem($id);
        if($item == "null") return;
        $checkNumber = $this->historyObj->getList("equip_id='{$item['id']}'", "time");
        $number = 0;
        foreach($checkNumber as $checkNumberItem){
            if($checkNumberItem['in_out'] == "in") $number += $checkNumberItem['number'];
            else $number -= $checkNumberItem['number'];
        }
        $item['number'] = $number;
        echo json_encode($item);
    }

    public function updateEquipment(){
        $data = json_decode($_GET['data']);
        $this->equipmentObj->updateItem($data);
        echo "UpdateEquipmentOK";
    }

    public function deleteEquipment(){
        $id = $_GET['id'];
        $this->equipmentObj->removeItem($id);
        $this->historyObj->removeItem($id);
        echo "DeleteEquipmentOK";
    }

    public function addHistory(){
        $data = json_decode($_GET['data']);
        $this->historyObj->addHistory($data);
        echo "AddHistoryOK";
    }

    public function search(){
        $keyword = $_GET['keyword'];
        $list = $this->equipmentObj->getList("name LIKE '%$keyword%' OR function LIKE '%$keyword%' OR producer LIKE '%$keyword%' OR provider LIKE '%$keyword%'", "id");
        for($i = 0; $i < count($list); $i++){
            $checkNumber = $this->historyObj->getList("equip_id='{$list[$i]['id']}'", "time");
            $number = 0;
            foreach($checkNumber as $checkNumberItem){
                if($checkNumberItem['in_out'] == "in") $number += $checkNumberItem['number'];
                else $number -= $checkNumberItem['number'];
            }
            $list[$i]['number'] = $number;
        }
        echo json_encode($list);
    }
}
?>