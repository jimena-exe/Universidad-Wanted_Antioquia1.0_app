package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class capa_iniciar_sesion : AppCompatActivity() {

    var usuarioInicSesion : EditText?=null
    var contrasenaInicSesion : EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_iniciar_sesion)

        usuarioInicSesion = findViewById(R.id.usuarioInicSesion)
        contrasenaInicSesion = findViewById(R.id.contrasenaInicSesion)

        }

    //botón lleva a la pag inicial "MainActivity"
    fun cancelarInicioSesion(view:View){
        val intent = Intent(this,opciones::class.java).apply {  }

        startActivity(intent)
    }

    fun validarUsuario() {
        val url = "http://192.168.1.68/Wanted-Antioquia/insertar_usuario.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPostInic = object : StringRequest(Request.Method.POST, url,
            Response.Listener<String> { response ->
                if (!response.isEmpty()) {
                    val intent = Intent(this, capa_registrar::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
                    val retroceder = Intent(this, opciones::class.java)
                    startActivity(retroceder)
                }
            }, Response.ErrorListener { error ->
                //Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
                val retroceder = Intent(this, MainActivity::class.java)
                startActivity(retroceder)
            }) {
            override fun getParams(): MutableMap<String, String> {
                val parametrosInic = HashMap<String, String>()
                parametrosInic.put("usuario", usuarioInicSesion?.text.toString())
                parametrosInic.put("contraseña", contrasenaInicSesion?.text.toString())
                return parametrosInic
            }

        }
        queue.add(resultadoPostInic)
    }




    }
