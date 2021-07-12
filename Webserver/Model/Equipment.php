<?php
require_once "functions.php";
require_once "DB.php";

class Equipment extends DB{
	
	public function __construct(){
		parent::__construct();
	}

	public function getList($cond = "1", $order = ""){
		return $this->select("equipment", "*", $cond, $order);
	}

	public function getItem($id){
		$item = $this->select("equipment", "*", "id='$id'");
		if(count($item) == 1){
			return $item[0];
		}
		return "null";
	}

	public function addItem($data){
		$this->insert("equipment", array('id' => $data->id,
											'name' => $data->name,
											'status' => $data->status,
											'producer' => $data->producer,
											'provider' => $data->provider,
											'function' => $data->function,
											'price' => $data->price));
	}

	public function updateItem($data){
		$this->update("equipment", array('id' => $data->id,
											'name' => $data->name,
											'status' => $data->status,
											'producer' => $data->producer,
											'provider' => $data->provider,
											'function' => $data->function,
											'price' => $data->price), "id='{$data->old_id}'");
	}

	public function removeItem($id){
		$this->delete("equipment", "id='$id'");
	}
}
?>