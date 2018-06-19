package com.example.eddymontesinos.preojectlogin

import android.app.Application
import android.arch.persistence.room.Room
import com.example.eddymontesinos.preojectlogin.database.DemoDataBase

class DemoApplication : Application(){

    companion object {
        var database: DemoDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this,DemoDataBase::class.java,"tablaUsuario").build()
    }
}