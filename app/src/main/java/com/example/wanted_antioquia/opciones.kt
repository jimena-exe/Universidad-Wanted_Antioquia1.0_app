package com.example.wanted_antioquia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)
    }

    //botón lleva a la pag Iniciar sesión
    fun abrirInicioSesion(view: View){
        val intent = Intent(this,capa_iniciar_sesion::class.java).apply {  }

        startActivity(intent)
    }

    //boton lleva a la pag Noticias recientes
    fun irANoticias(view: View){
        val intent = Intent(this, capa_lista_personas::class.java).apply {  }

        startActivity(intent)
    }

    //boton lleva a la pag Buscar persona desaparecida
    fun irABuscarPersona(view: View){
        val intent = Intent(this, conector_ver_denuncia::class.java).apply {  }

        startActivity(intent)
    }

    //boton lleva a la pag Técnicas de rastrep
    fun irATecnicas(view: View){
        val tecnicas = Intent(this, capa_tecnicas::class.java).apply {  }

        startActivity(tecnicas)
    }

    //boton lleva a la pag Consejos de prevensión
    fun irAConsejos(view: View){
        val consejos = Intent(this, capa_consejos::class.java).apply {  }

        startActivity(consejos)
    }
    //boton lleva a la pag Información de la app
    fun irAInformacion(view: View){
        val informacion = Intent(this, capa_info_app::class.java).apply {  }

        startActivity(informacion)
    }
    //boton lleva a la pag Ir al perfil
     fun irAPerfil(view: View){
        val perfil = Intent(this, capa_denunciar1::class.java).apply {  }

        startActivity(perfil)
     }

    //botón lleva a la pag Denunciar desaparecido
    fun irADenunciar(view: View){
        val denunciar = Intent(this, capa_denunciar1::class.java).apply {  }
        startActivity(denunciar)
    }
}