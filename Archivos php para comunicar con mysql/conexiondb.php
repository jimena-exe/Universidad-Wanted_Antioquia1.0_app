<?php
$mysql=new mysqli("localhost","root","","wanted_antioquia_mysql");
if($mysql->connect_error){
    die("Error de conexion");
}
else{
    //echo "Conexion exitosa";
}