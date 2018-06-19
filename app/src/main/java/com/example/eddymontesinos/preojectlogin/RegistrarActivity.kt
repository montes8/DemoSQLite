package com.example.eddymontesinos.preojectlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.eddymontesinos.preojectlogin.adapter.UsuarioAdapter
import com.example.eddymontesinos.preojectlogin.model.Usuario
import kotlinx.android.synthetic.main.activity_registrar.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

import org.jetbrains.anko.toast
import java.io.File


class RegistrarActivity : AppCompatActivity() {

    private val userAdapter = UsuarioAdapter()

    private val CARPETA_RAIZ = "misImagenes/"
    private val RUTA_IMAGE = CARPETA_RAIZ + "misFotos"
    var nombreImagen: String = ""
    var path: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        ajusteToolbar()
        cargarImagenGaleria()

        button_click_register.setOnClickListener{


            Thread {
                val usuario = Usuario()
                usuario.nombre = edit_text_nombre.text.toString()
                usuario.nombreUsuario = edit_text_user.text.toString()
                usuario.contraseña = edit_password.text.toString()
                usuario.pais = edit_pais.text.toString()

                DemoApplication.database!!.usuarioDao().insert(usuario)
                DemoApplication.database!!.usuarioDao().listas().forEach{

                    Log.d("listanombre", "nombre -- ${it.nombre}")
                    Log.d("listaApellido", "apellido -- ${it.nombreUsuario}")
                    Log.d("listaPassword", "pasword -- ${it.contraseña}")
                    Log.d("listaPaises", "paises -- ${it.pais}")
                }

            }.start()

            startActivity<PruebaActivity>()

         }


      }







    private fun ajusteToolbar(){
        setSupportActionBar(mToolbar)
        title = getString(R.string.toolbar_registrate)
        mToolbar.navigationIcon = getDrawable(R.drawable.flecha_back)
        mToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun cargarImagen() {
        //metodo simple cargaimagenes de galeria
        //val intent:Intent = Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        val opciones = arrayOf<CharSequence>("Tomar foto", "Cargar imagen", "Cancelar")
        val alertOpciones = AlertDialog.Builder(this@RegistrarActivity)
        alertOpciones.setTitle("Seleccione una Opcion")
        alertOpciones.setItems(opciones) { dialog, i ->
            if (opciones[i] == "Tomar foto") {
                toast("llamar a la camara")

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

    private fun tomarFotografia() {

        val fileImage = File(Environment.getExternalStorageDirectory(), RUTA_IMAGE)
        var isCreada = fileImage.exists()

        if (isCreada == false) {
            isCreada = fileImage.mkdirs()
        }
        if (isCreada == true) {

            nombreImagen = (System.currentTimeMillis() / 100).toString() + "jpg"
        }
        // indica la ruta de almacenamiento
        path = Environment.getExternalStorageDirectory().toString() + File.separator + RUTA_IMAGE + File.separator + nombreImagen
        //crear archivo
        val imagen = File(path)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen))
        startActivityForResult(intent, 20)


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


