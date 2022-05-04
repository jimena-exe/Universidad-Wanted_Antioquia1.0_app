package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class capa_lista_personas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa_lista_personas)

    //----------ennsayo de listado de personas-----------------

        //un array que permite trabajar los elementos que van dentro del listView
        val arrayAdapter:ArrayAdapter<*>
        //lista
        val personas = mutableListOf("Laura","Diego","Iasías")
        //variable que llama de la interfaz gráfica al listView
        val lista_personas = findViewById<ListView>(R.id.lista_personas)
        //para llenarlo
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,personas)

        lista_personas.adapter = arrayAdapter
    }

    fun volverAOpciones(view: View){
        val intent = Intent(this, opciones::class.java).apply {  }

        startActivity(intent)
    }





}