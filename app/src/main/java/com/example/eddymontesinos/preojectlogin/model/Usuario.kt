package com.example.eddymontesinos.preojectlogin.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
class Usuario (
        @PrimaryKey(autoGenerate = true)
        var idUsu : Long? = null,

        var nombre : String? = "",

        var nombreUsuario : String? = "",

        var contrasena :String? = "",

        var pais :String? = ""
): Parcelable




