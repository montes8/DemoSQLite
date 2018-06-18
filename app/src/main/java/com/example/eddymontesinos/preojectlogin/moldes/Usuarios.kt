package com.example.eddymontesinos.preojectlogin.moldes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Usuarios {

    @PrimaryKey(autoGenerate = true)
    var idUsu : Long? = null

    var nombre : String? = null

    var nombreUsuario : String? = null

    var contraseña :String? = null

    var pais :String? = null
}