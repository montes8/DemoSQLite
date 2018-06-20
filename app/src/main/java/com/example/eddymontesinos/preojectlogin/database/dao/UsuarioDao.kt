package com.example.eddymontesinos.preojectlogin.database.dao

import android.arch.persistence.room.*
import com.example.eddymontesinos.preojectlogin.model.Usuario

@Dao
interface UsuarioDao {

    @Query("select * from Usuario")
    fun listas(): List<Usuario>

    @Query("select * from Usuario where nombreUsuario = :name and contrasena = :pass")
    fun userLogin(name:String,pass:String):Usuario

    @Query("select * from Usuario where idUsu = :id")
    fun verDetalleUsuarioLogeado(id : String ): Usuario


    @Insert
    fun insert(usuarios: Usuario)

    @Delete
    fun deleteUser(usuarios: Usuario):Int

    @Update
    fun updateUser(usuarios: Usuario)
}