package com.example.eddymontesinos.preojectlogin.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Usuario (
        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String? = "",

        var nombreUsuario : String? = "",

        var contraseña :String? = "",

        var pais :String? = ""
)




