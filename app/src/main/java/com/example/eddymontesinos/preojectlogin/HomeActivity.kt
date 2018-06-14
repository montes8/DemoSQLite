package com.example.eddymontesinos.preojectlogin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    var drawerLayout :DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        drawerLayout = findViewById(R.id.drawer_layout)

        setSupportActionBar(mToolbar_home )
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_navigation)//definimco que imagen queremos llamr la imagen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)//habilitamos el icono



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
              android.R.id.home -> {
                  drawerLayout!!.openDrawer(GravityCompat.START)
                  return true
              }

        }
        return super.onOptionsItemSelected(item)
    }
}
