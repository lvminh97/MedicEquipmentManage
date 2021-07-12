<?php
require_once "Controller.php";
class ViewController extends Controller{

    public function __construct(){
        parent::__construct();
    }

    public function getIndex(){
        // if($this->accountObj->checkLoggedIn() == "Role_User") $user = $this->accountObj->getItem($_SESSION['Medic_Cuid']);
        // else $user = "null";
        // getView("home", array('title' => "Quản lý thiết bị",
        //                         'banner' => "true",
        //                         'menu' => 'true',
        // ));                    
    }

    public function getEquipment(){
        if($this->accountObj->checkLoggedIn() == "Role_None"){
            getView("login", array());
        }
        else{
            if(isset($_GET['search'])){
                $keyword = $_GET['search'];
                $cond = "name LIKE '%$keyword%' OR function LIKE '%$keyword%' OR producer LIKE '%$keyword%' OR provider LIKE '%$keyword%'";
            }
            else
                $cond = "1";
            $list = $this->equipmentObj->getList($cond, "id");
            for($i = 0; $i < count($list); $i++){
                $checkNumber = $this->historyObj->getList("equip_id='{$list[$i]['id']}'", "time");
                $number = 0;
                foreach($checkNumber as $checkNumberItem){
                    if($checkNumberItem['in_out'] == "in") $number += $checkNumberItem['number'];
                    else $number -= $checkNumberItem['number'];
                }
                $list[$i]['number'] = $number;
            }
            getView("equipment_list", array('equipment_list' => $list,
                                            'account' => $this->accountObj->getItem($_SESSION['MedicEquip_user'])));
        }
    }

    public function getHistoryList(){
        $id = $_GET['id'];
        $list = $this->historyObj->getList("equip_id='$id'", "time ASC");
        foreach($list as $item){
            echo "<tr>";
            echo "<td>".$item['time']."</td>";
            echo "<td>".$this->accountObj->getItem($item['username'])['fullname']."</td>";
            echo "<td>".$item['number']."</td>";
            echo "<td>".($item['in_out'] == "in" ? "Nhập" : "Xuất")."</td>";
            echo "</tr>";
        }
    }
}
?>