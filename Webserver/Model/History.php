<?php
require_once "functions.php";
require_once "DB.php";

class History extends DB{
	public function __construct(){
		parent::__construct();
	}

	public function getList($cond = "1", $order = ""){
		return $this->select("history", "*", $cond, $order);
	}

	// public function getItem($assignment_id){
	// 	return $this->getList("assignment_id='$assignment_id'")[0];
	// }

	public function addItem($data){
		$this->insert("history", array('time' => date("Y-m-d H:i:s"),
										'equip_id' => $data->id,
										'username' => $data->username,
										'number' => $data->number,
										'in_out' => 'in'));
	}

	public function addHistory($data){
		$this->insert("history", array('time' => date("Y-m-d H:i:s"),
										'equip_id' => $data->id,
										'username' => $data->username,
										'number' => $data->number,
										'in_out' => $data->in_out));
	}

	public function removeItem($equip_id){
		$this->delete("history", "equip_id='$equip_id'");
	}
}
?>