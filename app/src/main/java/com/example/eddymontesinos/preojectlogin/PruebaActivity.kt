package com.example.eddymontesinos.preojectlogin



import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.eddymontesinos.preojectlogin.moldes.Usuarios
import kotlinx.android.synthetic.main.activity_prueba.*
import org.jetbrains.anko.toast


class PruebaActivity : AppCompatActivity() {

    var usuAdapter : UsuarioAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)

        usuAdapter = UsuarioAdapter()
        rvPeople.layoutManager = LinearLayoutManager(this@PruebaActivity)
        rvPeople.adapter = usuAdapter

        val handler = Handler()

        Thread {
            val lista = DemoApplication.database!!.usuarioDao().listas()
            handler.post{
                usuAdapter!!.addList(lista)
            }
        }.start()
/*
        val tarea = object : AsyncTask<Void, Void, List<Usuarios>>(){
         override fun doInBackground(vararg params: Void?): List<Usuarios> {
            return DemoApplication.database!!.usuarioDao().listas()
            }
              override fun onPostExecute(result: List<Usuarios>?) {
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
