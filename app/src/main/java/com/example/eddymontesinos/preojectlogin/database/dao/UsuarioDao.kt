package com.example.eddymontesinos.preojectlogin.database.dao

import android.arch.persistence.room.*
import com.example.eddymontesinos.preojectlogin.model.Usuario

@Dao
interface UsuarioDao {

    @Query("select * from Usuario")
    fun listas(): List<Usuario>

    @Insert
    fun insert(usuarios: Usuario)

    @Delete
    fun deleteUser(usuarios: Usuario):Int
}