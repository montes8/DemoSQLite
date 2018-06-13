package com.example.eddymontesinos.preojectlogin


import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.widget.Toast
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
        //metodo simple cargaimagenes de galeria
        //val intent:Intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        val opciones = arrayOf<CharSequence>("Tomar foto", "Cargar imagen", "Cancelar")
        val alertOpciones = AlertDialog.Builder(this@RegistrarActivity)
        alertOpciones.setTitle("Seleccione una Opcion")
        alertOpciones.setItems(opciones) { dialog, i ->
            if (opciones[i] == "Tomar foto") {

                Toast.makeText(application, "tomar foto", Toast.LENGTH_LONG).show()

            } else {
                if (opciones[i] == "Cargar imagen") {

                    val intent:Intent = Intent(Intent.ACTION_GET_CONTENT,android.provider
                            .MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    intent.type = "image/"
                    startActivityForResult(intent,10)
                } else {
                    dialog.dismiss()
                }
            }
        }
        alertOpciones.show()


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


