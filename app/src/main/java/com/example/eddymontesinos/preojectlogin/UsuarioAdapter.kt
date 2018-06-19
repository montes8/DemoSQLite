package com.example.eddymontesinos.preojectlogin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.preojectlogin.moldes.Usuarios
import kotlinx.android.synthetic.main.molde_user.view.*

class UsuarioAdapter : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){

    private var user : List<Usuarios>? = null

    fun addList(user : List<Usuarios>){
        this.user = user
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view :View = LayoutInflater.from(parent.context).inflate(R.layout.molde_user,parent,false)
        return UsuarioViewHolder(view)
    }

    override fun getItemCount(): Int {
        val checkedUser = checkNotNull(user){return 0}
        return checkedUser.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val users = user!![position]
        holder.txNombre.text = users.nombre
        holder.txUser.text = users.nombreUsuario
        holder.txPassword.text = users.contraseña
    }



    class UsuarioViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val txNombre = itemView.text_nombre
        val txUser = itemView.text_usuario
        val txPassword = itemView.text_password
    }

}