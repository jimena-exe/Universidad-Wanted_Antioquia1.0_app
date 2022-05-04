package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.net.URL

class capa_ver_denuncia : AppCompatActivity() {

    var verMunicipioDenun: EditText? = null
    var verNombreDesapaDenun: EditText? = null
    var verTipoDocument: EditText? = null
    var verNumDocumentoDenun: EditText? = null
    var verEstaturaDenun: EditText? = null
    var verEdadDenun: EditText? = null
    var verGeneroDenun: EditText? = null
    var verEnfermedadesDenun: EditText? = null
    var verInformacionAdicionalDenun: EditText? = null
    var verFechaDesaparicionDenun: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_ver_denuncia)

        verMunicipioDenun = findViewById(R.id.verMunicipioDenunc)
        verNombreDesapaDenun = findViewById(R.id.verNombreDenunci2)
        verTipoDocument = findViewById(R.id.verTipoDocumenDenun)
        verNumDocumentoDenun = findViewById(R.id.verDocumentoDenunci)
        verEstaturaDenun = findViewById(R.id.verEstaturaDenunci)
        verEdadDenun = findViewById(R.id.verEdadDenunci)
        verGeneroDenun = findViewById(R.id.verGeneroDenun)
        verEnfermedadesDenun = findViewById(R.id.verEnfermedadesDenunci)
        verInformacionAdicionalDenun = findViewById(R.id.verInfoAdiciDenunci)
        verFechaDesaparicionDenun = findViewById(R.id.verFechaDesapaDenunci)



        val nume_documento =intent.getStringExtra("num_documento").toString()

        val queue=Volley.newRequestQueue(this)
        val url = "http://192.168.1.68/Wanted-Antioquia/consultar_desaparicion.php?num_documento=${nume_documento}"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null, Response.Listener { response ->
                verMunicipioDenun?.setText(response.getString("municipio"))
                verNombreDesapaDenun?.setText(response.getString("nombre_desaparecido"))
                verTipoDocument?.setText(response.getString("tipo_documento"))
                verNumDocumentoDenun?.setText(response.getString("num_documento"))
                verEstaturaDenun?.setText(response.getString("estatura"))
                verEdadDenun?.setText(response.getString("edad"))
                verGeneroDenun?.setText(response.getString("genero"))
                verEnfermedadesDenun?.setText(response.getString("enfermedades"))
                verInformacionAdicionalDenun?.setText(response.getString("informacion_adicional"))
                verFechaDesaparicionDenun?.setText(response.getString("fecha_desaparicion"))
            }, Response.ErrorListener { error ->
                Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show()
            }
        )

        queue.add(jsonObjectRequest)
    }

    fun clickParaVover(view: View){
        val intent = Intent(this, opciones::class.java).apply {  }
        startActivity(intent)
    }
}