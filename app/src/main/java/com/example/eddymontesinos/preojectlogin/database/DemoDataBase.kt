package com.example.eddymontesinos.preojectlogin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.eddymontesinos.preojectlogin.database.dao.UsuarioDao
import com.example.eddymontesinos.preojectlogin.model.Usuario


@Database(entities = [Usuario::class],version = 1)
abstract class DemoDataBase : RoomDatabase(){
    abstract fun usuarioDao(): UsuarioDao


}