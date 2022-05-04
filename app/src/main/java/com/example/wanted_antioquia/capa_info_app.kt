package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class capa_info_app : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_info_app)
    }

    //Funcion botón llevar a la pag de opciones "MainActivity"
    fun volverAOpciones1(view: View){
        val intent = Intent(this, opciones::class.java).apply {  }

        startActivity(intent)
    }
}