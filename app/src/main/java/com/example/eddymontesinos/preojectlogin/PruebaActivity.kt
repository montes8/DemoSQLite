package com.example.eddymontesinos.preojectlogin

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eddymontesinos.preojectlogin.database.DemoDataBase
import com.example.eddymontesinos.preojectlogin.moldes.Usuarios

class PruebaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)

        val db: DemoDataBase = Room.databaseBuilder(applicationContext,
                DemoDataBase::class.java,
                "tablapersonas").build()

        Thread {
            val usuario = Usuarios()
            usuario.nombre = "Gabii"
            usuario.nombreUsuario = "sardelli"
            usuario.contraseña = "hola"
            usuario.pais = "Argentina"

            db.usuarioDao().insert(usuario)
            db.usuarioDao().listas().forEach() {

                Log.d("listapesonas", "nombre -- ${it.nombre}")
                Log.d("listapesonas", "apellido -- ${it.nombreUsuario}")
                Log.d("listapesonas", "contraseña -- ${it.contraseña}")
            }

        }.start()
    }
}
