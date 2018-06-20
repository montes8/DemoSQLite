package com.example.eddymontesinos.preojectlogin

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.graphics.Typeface
import android.os.Handler
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.text.method.LinkMovementMethod
import org.jetbrains.anko.*


class LoginActivity : AppCompatActivity() {

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configurarTextoRegistrate()

        logearse()



    }

    fun configurarTextoRegistrate(){
        val string = getString(R.string.registrate)
        val spannableStringBuilder = SpannableStringBuilder(string)
        val boldSpan = StyleSpan(Typeface.BOLD)

        val clickableSpan = object: ClickableSpan() {

            override fun onClick(widget: View?) {
                startActivity<RegistrarActivity>()
            }
        }
        spannableStringBuilder.setSpan(boldSpan, 13, string.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(clickableSpan, 13, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvRegistrate.text=spannableStringBuilder
        tvRegistrate.movementMethod = LinkMovementMethod.getInstance()

    }

    fun logearse(){
        button_login.setOnClickListener {

            Thread{
                val usuario= DemoApplication.database?.usuarioDao()?.userLogin(edit_nombre_login.text.toString(),edit_password_login.text.toString())
                if (usuario!=null){
                    handler.post {
                        startActivity(intentFor<HomeActivity>().newTask().clearTask())
                    }
                }else {
                    handler.post {
                        toast("Usuario o Contraseña Incorrectos")
                    }
                }
            }.start()

        }

    }


}
