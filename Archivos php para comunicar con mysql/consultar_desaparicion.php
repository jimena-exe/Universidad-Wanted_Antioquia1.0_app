<?php
if($_SERVER["REQUEST_METHOD"]=="GET"){
    require_once 'conexiondb.php';
    $num_documento=$_GET['num_documento'];
    $query="SELECT * FROM denuncias WHERE num_documento='".$num_documento."'";
    $resultado=$mysql->query($query);
    if($mysql->affected_rows > 0){
        while($row=$resultado->fetch_assoc()){
            $array=$row;
        }
        echo json_encode($array);
    }else{
        echo "No hay registros";
    }
    $resultado->close();
    $mysql->close();
} 

