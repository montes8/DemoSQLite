package com.example.eddymontesinos.preojectlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.graphics.Typeface
import android.text.Spanned
import android.text.style.StyleSpan
import kotlinx.android.synthetic.main.activity_main.*


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

        spannableStringBuilder.setSpan(boldSpan, 13, string.length,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        tvRegistrate.text = spannableStringBuilder
    }
}
