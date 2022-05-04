package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class capa_registrar : AppCompatActivity() {
    var correoRegistro : EditText?=null
    var contrasenaRegistro : EditText?=null
    var nombreRegistro: EditText?=null
    var cedulaRegistro: EditText?=null
    var ciudadRegistro: EditText?=null
    var celularRegistro: EditText?=null
    var informacionAdicionalRegis: EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_registrar)

        correoRegistro = findViewById(R.id.correo_registro)
        contrasenaRegistro = findViewById(R.id.contrasena_registro)
        nombreRegistro = findViewById(R.id.nombre_registro)
        cedulaRegistro = findViewById(R.id.cedula_registro)
        ciudadRegistro=findViewById(R.id.ciudad_registro)
        celularRegistro=findViewById(R.id.celular_registro)
        informacionAdicionalRegis=findViewById(R.id.info_adic_registro)
    }

    //Funcion botón llevar a la pag inicial "MainActivity"
    fun cancelarResgistro(view:View){
        val intent = Intent(this,MainActivity::class.java).apply {  }

        startActivity(intent)
    }

    //Funcion Registrar usuario
    fun registrarUsuario(view: View) {
        val url = "http://192.168.1.68/Wanted-Antioquia/registrarse.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPostRegis = object : StringRequest(Request.Method.POST,url,
            Response.Listener <String> { response ->
                Toast.makeText(this,"Usuario registrado correctamente", Toast.LENGTH_LONG).show()
                val iniciar = Intent(this, capa_iniciar_sesion::class.java)
                startActivity(iniciar)
            }, Response.ErrorListener { error ->
                Toast.makeText(this,"Error $error", Toast.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String> {
                val parametrosRegistr=HashMap<String,String>()
                parametrosRegistr.put("nombre_usuario",nombreRegistro?.text.toString())
                parametrosRegistr.put("cedula",cedulaRegistro?.text.toString())
                parametrosRegistr.put("email",correoRegistro?.text.toString())
                parametrosRegistr.put("contraseña",contrasenaRegistro?.text.toString())
                parametrosRegistr.put("ciudad",ciudadRegistro?.text.toString())
                parametrosRegistr.put("numero_celular",celularRegistro?.text.toString())
                parametrosRegistr.put("informacion_adicional",informacionAdicionalRegis?.text.toString())
                return parametrosRegistr
            }
        }
        queue.add(resultadoPostRegis)
    }



}