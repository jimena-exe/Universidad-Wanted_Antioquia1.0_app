<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'conexiondb.php';
    $nombre_reportar=$_POST["nombre_reportar"];
    $ciudad_report=$_POST["ciudad_report"];
    $edad_report=$_POST["edad_report"];
    $detalles=$_POST["detalles"];
    $query= "INSERT INTO reportarpersonadb
               (nombre_reportar ,ciudad_report ,edad_report ,detalles)
    VALUES('".$nombre_reportar."','".$ciudad_report."','".$edad_report."','".$detalles."')";
    $resultado=$mysql->query($query);
    if($resultado==true){
        echo "El reporte se ingreso de forma exitosa";
    }
    else{
        echo "Error al reportar usuario";
    }
}