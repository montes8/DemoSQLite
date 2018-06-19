package com.example.eddymontesinos.preojectlogin.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eddymontesinos.preojectlogin.DemoApplication
import com.example.eddymontesinos.preojectlogin.R
import com.example.eddymontesinos.preojectlogin.model.Usuario
import kotlinx.android.synthetic.main.molde_user.view.*

class UsuarioAdapter(var onEliminarClick: ((Usuario) -> Unit)? = null  ) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>(){

    private var user : List<Usuario>? = null

    fun addList(user : List<Usuario>){
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

        holder.buttonClick.setOnClickListener{

            onEliminarClick?.invoke(users)
        }

    }



    class UsuarioViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val txNombre = itemView.text_nombre
        val txUser = itemView.text_usuario
        val txPassword = itemView.text_password
        val buttonClick= itemView.image_delete_user
    }

}