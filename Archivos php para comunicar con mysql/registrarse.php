<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'conexiondb.php';
    $nombre_usuario=$_POST["nombre_usuario"];
    $cedula=$_POST["cedula"];
    $email=$_POST["email"];
    $contraseña=$_POST["contraseña"];
    $ciudad=$_POST["ciudad"];
    $numero_celular=$_POST["numero_celular"];
    $informacion_adicional=$_POST["informacion_adicional"];
    $query= "INSERT INTO usuarios 
               (nombre_usuario ,cedula ,email ,contraseña ,ciudad ,numero_celular ,informacion_adicional)
    VALUES('".$nombre_usuario."','".$cedula."','".$email."','".$contraseña."','".$ciudad."','".$numero_celular."','".$informacion_adicional."')";
    $resultado=$mysql->query($query);
    if($resultado==true){
        echo "El usuario se registro de forma exitosa";
    }
    else{
        echo "Error al registrar usuario";
    }
}