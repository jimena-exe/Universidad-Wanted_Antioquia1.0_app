package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class capa_tecnicas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_tecnicas)
    }

    //botón lleva a la pag Opciones
    fun volverAOpciones(view: View){
        val intent = Intent(this, opciones::class.java).apply {  }

        startActivity(intent)
    }
}