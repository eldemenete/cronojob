package com.example.cronojob.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cronojob.R
import com.example.cronojob.model.Cliente


class ClienteAdapter(private val clientes: List<Cliente>, private val onDelete: (Cliente) -> Unit) : RecyclerView.Adapter<ClienteAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.tv_nombre_cliente)
        val correoTextView: TextView = view.findViewById(R.id.tv_correo)
        val btnDelete: Button = view.findViewById(R.id.btn_delete_cliente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cliente = clientes[position]
        holder.nombreTextView.text = cliente.nombre
        holder.correoTextView.text = cliente.correo
        holder.btnDelete.setOnClickListener { onDelete(cliente) }
    }

    override fun getItemCount() = clientes.size
}
