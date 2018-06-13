package com.example.eddymontesinos.preojectlogin


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_registrar.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class RegistrarActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)



        val toolbar:Toolbar = findViewById(R.id.activity_toolbar_register)
        toolbar.title=getString(R.string.toolbar_registrate)




     cargarImagenGaleria()
    }

    private fun cargarImagen() {
        val intent:Intent = Intent(Intent.ACTION_PICK,android.provider
                           .MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/"
        startActivityForResult(intent,10)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== Activity.RESULT_OK){
            val path: Uri = data!!.data
            profile_image.setImageURI(path)
        }
    }
    fun cargarImagenGaleria(){

        button_cargar_img.onClick {
            cargarImagen()
        }


    }
}


