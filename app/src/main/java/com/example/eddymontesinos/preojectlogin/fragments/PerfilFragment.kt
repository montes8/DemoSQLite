package com.example.eddymontesinos.preojectlogin.fragments


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.preojectlogin.DemoApplication
import com.example.eddymontesinos.preojectlogin.R
import kotlinx.android.synthetic.main.fragment_perfil.*
import org.jetbrains.anko.support.v4.defaultSharedPreferences

class PerfilFragment : Fragment() {

    var handler : Handler = Handler()

   var miVista : View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        miVista = inflater.inflate(R.layout.fragment_perfil, container, false)
        val btn_llamada = miVista?.findViewById<View>(R.id.imageView2)

        Thread {
            val idUsu = defaultSharedPreferences.getString("pass","")
            val user= DemoApplication.database?.usuarioDao()?.verDetalleUsuarioLogeado(idUsu)
                handler.post {
                    text_nombre_p.text = user?.nombre
                    text_usuario_p.text = user?.nombreUsuario
                    text_contraseña_p.text = user?.contrasena
                    text_pais_p.text = user?.pais
                }

        }.start()



        btn_llamada?.setOnClickListener{
            val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"))
            startActivity(intentCall)

        }
        return miVista
    }


}
