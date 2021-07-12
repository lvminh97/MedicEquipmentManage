<?php
function setTimeZone(){
    date_default_timezone_set('asia/ho_chi_minh');
}

function sessionInit(){
    if (session_status() == PHP_SESSION_NONE) {
        session_start();
    }
}

function getView($view, $data = null){
    $viewParams = $data;
    require_once "View/$view.view.php";
}

function getTemplate($template, $data = null){
    $viewParams = $data;
    require_once "View/Template/$template.template.php";
}

function getModal($modal, $data = null){
    $viewParams = $data;
    require_once "View/Modal/$modal.modal.php";
}

function notice_and_nextpage($mess, $link){
    echo "<html><head>"
        ."<meta charset=\"UTF-8\">"
        ."<title>Thông báo</title></head>"
        ."<body>"
            ."<script>"
                ."alert(\"$mess\");"
                ."window.location=\"$link\";"
            ."</script>"
        ."</body>"
        ."</html>";
}

function notice($mess){
    echo "<script>alert(\"$mess\");</script>";
}

function nextpage($link){
    ob_start();
    header("location: $link");
    ob_flush();
}

function debug($var){
    echo "<script>console.log('$var');</script>";
}

function _hash($data){
    return sha1(sha1($data));
}

function randString($length){
    $chars="abcdefghijklmnopqrstuvwxyz0123456789";
    $str="";
    for($i = 0; $i < $length; $i++)
        $str .= $chars[rand(0,35)];
    return $str;
}

function echo_max_len($str, $len){
    if(strlen($str) <= $len){
        echo $str;
    }
    else {
        echo substr($str, 0, $len)."...";
    }
}

function cartCount(){
    $cookieKeys = array_keys($_COOKIE);
	$num = 0;
	foreach($cookieKeys as $key){
		if(strpos($key, 'medic_') !== false && $_COOKIE[$key] > 0) $num++;
	}
	return $num;
}
?>