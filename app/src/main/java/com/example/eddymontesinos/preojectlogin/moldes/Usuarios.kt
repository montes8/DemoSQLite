package com.example.eddymontesinos.preojectlogin.moldes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Usuarios (
        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String? = "",

        var nombreUsuario : String? = "",

        var contraseña :String? = "",

        var pais :String? = ""
)




