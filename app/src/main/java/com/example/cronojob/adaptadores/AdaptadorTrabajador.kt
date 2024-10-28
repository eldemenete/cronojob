package com.example.cronojob.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cronojob.R
import com.example.cronojob.model.Trabajador



class TrabajadorAdapter(private val trabajadores: List<Trabajador>, private val onDelete: (Trabajador) -> Unit) : RecyclerView.Adapter<TrabajadorAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.tv_nombre)
        val puestoTextView: TextView = view.findViewById(R.id.tv_puesto)
        val btnDelete: Button = view.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trabajador, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trabajador = trabajadores[position]
        holder.nombreTextView.text = trabajador.nombre
        holder.puestoTextView.text = trabajador.puesto
        holder.btnDelete.setOnClickListener { onDelete(trabajador) }
    }

    override fun getItemCount() = trabajadores.size
}
