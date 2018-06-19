package com.example.eddymontesinos.preojectlogin.database.dao

import android.arch.persistence.room.*
import com.example.eddymontesinos.preojectlogin.moldes.Usuarios

@Dao
interface UsuarioDao {
    
    @Query("select * from Usuarios")
    fun listas() : List<Usuarios>

    @Insert
    fun insert (usuarios: Usuarios)
}