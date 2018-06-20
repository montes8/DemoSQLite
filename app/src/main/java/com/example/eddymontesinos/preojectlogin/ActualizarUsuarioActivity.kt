package com.example.eddymontesinos.preojectlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.eddymontesinos.preojectlogin.model.Usuario
import kotlinx.android.synthetic.main.activity_actualizar_usuario.*
import org.jetbrains.anko.toast


class ActualizarUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_usuario)

        val usuarioModificar = intent.getParcelableExtra<Usuario>("usuario")

        Log.i("actualizar", usuarioModificar.toString())

        edit_nombreModicar.setText(usuarioModificar.nombre)
        edit_usuarioModificar.setText(usuarioModificar.nombreUsuario)
        edit_contraseniaModificar.setText(usuarioModificar.contraseña)
        edit_paisModificar.setText(usuarioModificar.pais)

        button_actulizar.setOnClickListener{

            Thread {
                //val idUsu = edit_idac.text.toString().toLong()
                val nombre = edit_nombreModicar.text.toString()
                val nombreUsuario = edit_usuarioModificar.text.toString()
                val contraseña = edit_contraseniaModificar.text.toString()
                val pais = edit_paisModificar.text.toString()

                val usuario = Usuario()
                usuario.idUsu= usuarioModificar.idUsu
                usuario.nombre = nombre
                usuario.nombreUsuario = nombreUsuario
                usuario.contraseña = contraseña
                usuario.pais = pais

                DemoApplication.database!!.usuarioDao().updateUser(usuario)


            }.start()

            toast("Usuario Modificado")
            edit_nombreModicar.setText("")
            edit_usuarioModificar.setText("")
            edit_contraseniaModificar.setText("")
            edit_paisModificar.setText("")
        }
    }
}
