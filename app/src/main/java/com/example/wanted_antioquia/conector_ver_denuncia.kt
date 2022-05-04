package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText


class conector_ver_denuncia : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conector_ver_denuncia)

    }

    //botón cancelar denuncia
    fun cancelarBusqueda(view: View) {
        val intent = Intent(this, opciones::class.java).apply { }
        startActivity(intent)
    }

    //Enviar parametro ingresado en el String
    fun clickIr(view: View){
        var txtNumerDocu:EditText=findViewById<EditText>(R.id.txtNumerDocu)
        var intent=Intent(this, capa_ver_denuncia::class.java)
        intent.putExtra("num_documento",txtNumerDocu.text.toString())
        startActivity(intent)
    }
}