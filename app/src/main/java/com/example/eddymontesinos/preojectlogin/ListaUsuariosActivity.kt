package com.example.eddymontesinos.preojectlogin



import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

import com.example.eddymontesinos.preojectlogin.adapter.UsuarioAdapter
import com.example.eddymontesinos.preojectlogin.model.Usuario

import kotlinx.android.synthetic.main.activity_listausuarios.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class ListaUsuariosActivity : AppCompatActivity() {

    var usuAdapter : UsuarioAdapter? = null
    private lateinit var lista : List<Usuario>
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listausuarios)

            recyclerView()
            refrescarListar()

        }



    fun recyclerView(){
            usuAdapter = UsuarioAdapter()

            usuAdapter?.onActulizarUsuario= {

                val intent = Intent(this@ListaUsuariosActivity,ActualizarUsuarioActivity::class.java)
                intent.putExtra("usuario", it)
                startActivity(intent)

            }

            usuAdapter?.onEliminarClick = {
                Thread {
                    val resultado =  DemoApplication.database!!.usuarioDao().deleteUser(it)
                    Log.d("resultado", "$resultado")
                    if(resultado>0){
                        refrescarListar()
                    }else{
                        handler.post{
                            toast("Ocurrio un error al eliminar")
                        }
                    }
                }.start()
            }

            rvPeople.layoutManager = LinearLayoutManager(this@ListaUsuariosActivity)
            rvPeople.adapter = usuAdapter
     }

    private fun refrescarListar(){
        Thread {
            lista = DemoApplication.database!!.usuarioDao().listas()
            handler.post{
                usuAdapter!!.addList(lista)
            }
        }.start()

        /*
               val tarea = object : AsyncTask<Void, Void, List<Usuario>>(){
                override fun doInBackground(vararg params: Void?): List<Usuario> {
                   return DemoApplication.database!!.usuarioDao().listas()
                   }
                     override fun onPostExecute(result: List<Usuario>?) {
                       super.onPostExecute(result)
                           if(result != null){
                           usuAdapter!!.addList(result!!)
                       }else{
                           toast("lista nula")
                       }
                   }
               }
               tarea.execute()*/
    }

 }
