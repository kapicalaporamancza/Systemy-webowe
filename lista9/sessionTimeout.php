<?php

session_start();

$time = $_SERVER['REQUEST_TIME'];

if(!isset($_SESSION['TIMEOUT'])||$_SESSION['TIMEOUT']<$time){
    session_unset();
    session_destroy();
    session_start();
    $_SESSION['TIMEOUT'] = $time + 120;
}
?>
