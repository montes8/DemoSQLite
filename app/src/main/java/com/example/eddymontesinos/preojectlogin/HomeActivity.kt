package com.example.eddymontesinos.preojectlogin


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {

    var drawerLayout :DrawerLayout? = null
    var navigationView:NavigationView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawer_layout)//traemos la vista de nuestro draerLayout
        navigationView = findViewById(R.id.navigationView)

        setSupportActionBar(mToolbar_home )
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_navigation)//definimco que imagen queremos llamr la imagen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//habilitamos el icono

        navegacionDrawer()

    }

    //registramos evento navigationDrawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
              android.R.id.home -> {
                  drawerLayout!!.openDrawer(GravityCompat.START)
                  return true
              }
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
        navigationView!!.setNavigationItemSelectedListener { item ->
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
                    fragment = EmailFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_borrar -> {
                    toast("Borrar")
                }
                R.id.menu_ayuda -> {
                    toast("Ayuda")
                }
            }
            if (gestorDeFragmentos){
                cambiarFragmento(fragment,item)
                drawerLayout!!.closeDrawers()
            }
            true
        }

    }
}
