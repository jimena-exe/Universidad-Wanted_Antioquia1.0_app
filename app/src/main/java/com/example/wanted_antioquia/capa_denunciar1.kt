package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class capa_denunciar1 : AppCompatActivity() {

    var municipioDenun: EditText? = null
    var nombreDesapaDenun: EditText? = null
    var tipoDocument: EditText? = null
    var numDocumentoDenun: EditText? = null
    var estaturaDenun: EditText? = null
    var edadDenun: EditText? = null
    var generoDenun: EditText? = null
    var enfermedadesDenun: EditText? = null
    var informacionAdicionalDenun: EditText? = null
    var fechaDesaparicionDenun: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_denunciar1)


        municipioDenun = findViewById(R.id.verMunicipioDenunc)
        nombreDesapaDenun = findViewById(R.id.verNombreDenunci2)
        tipoDocument = findViewById(R.id.verTipoDocumenDenun)
        numDocumentoDenun = findViewById(R.id.verDocumentoDenunci)
        estaturaDenun = findViewById(R.id.verEstaturaDenunci)
        edadDenun = findViewById(R.id.verEdadDenunci)
        generoDenun = findViewById(R.id.verGeneroDenun)
        enfermedadesDenun = findViewById(R.id.verEnfermedadesDenunci)
        informacionAdicionalDenun = findViewById(R.id.verInfoAdiciDenunci)
        fechaDesaparicionDenun = findViewById(R.id.verFechaDesapaDenunci)

        }

        //botón cancelar denuncia
        fun cancelarDenuncia(view: View) {
            val intent = Intent(this, opciones::class.java).apply { }

            startActivity(intent)
        }


        //Funcion reportar persona
        fun reportarPersona(view: View) {
            val url = "http://192.168.1.68/Wanted-Antioquia/denuncias.php"
            val queue = Volley.newRequestQueue(this)
            var resultadoPostDenun = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response ->
                    Toast.makeText(this, "Persona reportada correctamente", Toast.LENGTH_LONG).show()
                    val iniciar = Intent(this, opciones::class.java)
                    startActivity(iniciar)
                }, Response.ErrorListener { error ->
                    Toast.makeText(this, "Error $error", Toast.LENGTH_LONG).show()
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val parametrosDenun = HashMap<String, String>()
                    parametrosDenun.put("municipio", municipioDenun?.text.toString())
                    parametrosDenun.put("nombre_desaparecido", nombreDesapaDenun?.text.toString())
                    parametrosDenun.put("tipo_documento", tipoDocument?.text.toString())
                    parametrosDenun.put("num_documento", numDocumentoDenun?.text.toString())
                    parametrosDenun.put("estatura", estaturaDenun?.text.toString())
                    parametrosDenun.put("edad", edadDenun?.text.toString())
                    parametrosDenun.put("genero", generoDenun?.text.toString())
                    parametrosDenun.put("enfermedades", enfermedadesDenun?.text.toString())
                    parametrosDenun.put("informacion_adicional", informacionAdicionalDenun?.text.toString())
                    parametrosDenun.put("fecha_desaparicion", fechaDesaparicionDenun?.text.toString())
                    return parametrosDenun
                }
            }
            queue.add(resultadoPostDenun)
        }

    }
