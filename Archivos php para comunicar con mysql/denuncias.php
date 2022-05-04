<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'conexiondb.php';
    $municipio=$_POST["municipio"];
    $nombre_desaparecido=$_POST["nombre_desaparecido"];
    $tipo_documento=$_POST["tipo_documento"];
    $num_documento=$_POST["num_documento"];
    $estatura=$_POST["estatura"];
    $edad=$_POST["edad"];
    $genero=$_POST["genero"];
    $enfermedades=$_POST["enfermedades"];
    $informacion_adicional=$_POST["informacion_adicional"];
    $fecha_desaparicion=$_POST["fecha_desaparicion"];
    $query= "INSERT INTO denuncias
      (municipio ,nombre_desaparecido ,tipo_documento ,num_documento ,estatura ,edad ,genero ,enfermedades ,informacion_adicional,fecha_desaparicion )
    VALUES('".$municipio."','".$nombre_desaparecido."','".$tipo_documento."','".$num_documento."','".$estatura."','".$edad."',
      '".$genero."','".$enfermedades."','".$informacion_adicional."','".$fecha_desaparicion."')";
    $resultado=$mysql->query($query);
    if($resultado==true){
        echo "La denuncia se creó de forma exitosa";
    }
    else{
        echo "Error al registrar denuncia";
    }
}