<?php
require_once "functions.php";
require_once "DB.php";

class Account extends DB{

	public function __construct(){
		parent::__construct();
	}

	public function getList($cond = "1", $order = ""){
		$list = $this->select("account", "*", $cond, $order);
		return $list;
	}

	public function getItem($username){
		$tmp = $this->getList("username='$username'");
		if(count($tmp) == 1) return $tmp[0];
		else return "null";
	}

	public function login($username, $password, $type = "web"){
		sessionInit();
		$check = $this->getList("username='$username' AND password='$password'");
		if(count($check) == 1){
			if($type == "app"){
				if($check[0]['role'] != "manage" && $check[0]['role'] != "admin"){
					return json_encode(array("status" => "NotRole"));
				}
			}
			$_SESSION['MedicEquip_user'] = $username;
			$_SESSION['MedicEquip_pass'] = $password;
			return json_encode(array("status" => "OK", "account" => $this->getItem($username)));
		}
		else{
			return json_encode(array("status" => "Wrong"));
		}
	}

	public function logout(){
		sessionInit();
		unset($_SESSION['MedicEquip_user']);
		unset($_SESSION['MedicEquip_pass']);
	}

	public function checkLoggedIn(){
		sessionInit();
		if(!isset($_SESSION['MedicEquip_user']) || !isset($_SESSION['MedicEquip_pass'])) return "Role_None";
		$check = $this->getList("username='{$_SESSION['MedicEquip_user']}' AND password='{$_SESSION['MedicEquip_pass']}'");
		if(count($check) != 1){
			$this->logout();
			return "Role_None";
		}
		else{
			return "Role_User";
		}
	}

	public function updateInfo($account_id, $fullname, $email, $mobile){
		// $this->db->execute("UPDATE account SET fullname='$fullname', email='$email', mobile='$mobile' WHERE account_id='$account_id'");
	}

	public function checkUsername($username){
		return count($this->getList("username='$username'")) == 0;
	}

	public function checkPassword($password, $password2){
		if(strlen($password) < 8)
			return 1; // password is too short
		elseif($password != $password2)
			return 2; // password is mismatch
		else
			return 0; // OK
	}

	public function changePassword($account_id, $new_password){
		$this->update("account", array('password' => $new_password), "account_id='$account_id'");
	}

	public function removeItem($account_id){
		$this->delete("account", "account_id='$account_id'");
	}
}
?>