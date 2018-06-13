package com.example.eddymontesinos.preojectlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.graphics.Typeface
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import android.view.View
import android.text.method.LinkMovementMethod
import android.widget.Toolbar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        configurarTextoRegistrate()

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


}
