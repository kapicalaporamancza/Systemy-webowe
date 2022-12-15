<?php
 ini_set('session.gc_maxlifetime', 300);
 ini_set('session.gc_divisor', 1);


session_start();

$time = $_SERVER['REQUEST_TIME'];

if(!isset($_SESSION['TIMEOUT'])||$_SESSION['TIMEOUT']<$time){
    session_unset();
    session_destroy();
    session_start();
    $_SESSION['TIMEOUT'] = $time + 120;
}
?>
