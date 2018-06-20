package com.example.eddymontesinos.preojectlogin


import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import com.example.eddymontesinos.preojectlogin.fragments.FotosFragment
import com.example.eddymontesinos.preojectlogin.fragments.PerfilFragment
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {

    lateinit var drawerLayout :DrawerLayout
    lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawer_layout)//traemos la vista de nuestro draerLayout
        navigationView = findViewById(R.id.navigationView)

        setSupportActionBar(mToolbar_home )
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_navigation)//definimco que imagen queremos llamr la imagen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//habilitamos el icono
        cambiarFragmento(PerfilFragment(),navigationView?.menu.getItem(0))
        navegacionDrawer()

    }

    //registramos evento navigationDrawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
              android.R.id.home -> {
                  drawerLayout!!.openDrawer(GravityCompat.START)
                  return true
              }

             R.id.ayuda ->{

             }
            R.id.cofiguracion ->{startActivity<ListaUsuariosActivity>()}

        }
        return super.onOptionsItemSelected(item)
    }

    fun cambiarFragmento(fragment:Fragment?,item:MenuItem){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit()
         item.isChecked = true
        supportActionBar!!.title = item.title
    }

    fun navegacionDrawer(){
        navigationView.setNavigationItemSelectedListener { item ->
            var gestorDeFragmentos = false
            var fragment : Fragment? = null
            when (item.itemId) {
                R.id.menu_perfil -> {
                    fragment = PerfilFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_fotos -> {
                    fragment = FotosFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_email -> {
                    //fragment = EmailFragment()
                    //gestorDeFragmentos = true
                    val email = "mi@gmial.com"
                    val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
                    intentEmail.type = "plain/text"
                    intentEmail.putExtra(Intent.EXTRA_SUBJECT,"Titulo del email")
                    intentEmail.putExtra(Intent.EXTRA_TEXT,"hola ,estoy esperando la respuesta")
                    intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("nvfrn@m.com","hola @gmail.com"))
                    startActivity(Intent.createChooser(intentEmail,"Elige Cliente de Correo"))
                }
                R.id.menu_borrar -> {
                    startActivity<ListaUsuariosActivity>()
                }
                R.id.menu_ayuda -> {
                    toast("Ayuda")
                }
            }
            if (gestorDeFragmentos){
                cambiarFragmento(fragment,item)
                drawerLayout?.closeDrawers()
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_horizontal, menu)
        return true
    }
}
