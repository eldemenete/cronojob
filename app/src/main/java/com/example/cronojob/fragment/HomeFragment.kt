package com.example.cronojob.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cronojob.R
import com.google.android.material.button.MaterialButton
import com.example.cronojob.adaptadores.ClienteAdapter
import com.example.cronojob.adaptadores.TrabajadorAdapter
import com.example.cronojob.model.Cliente
import com.example.cronojob.model.Trabajador
import com.example.cronojob.repositorio.Repositorio

class HomeFragment : Fragment() {

    private lateinit var btnAddTrabajador: MaterialButton
    private lateinit var btnAddCliente: MaterialButton
    private lateinit var trabajadorAdapter: TrabajadorAdapter
    private lateinit var clienteAdapter: ClienteAdapter
    private lateinit var rvTrabajadores: RecyclerView
    private lateinit var rvClientes: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        btnAddTrabajador = view.findViewById(R.id.btn_add_trabajador)
        btnAddCliente = view.findViewById(R.id.btn_add_cliente)
        rvTrabajadores = view.findViewById(R.id.rv_trabajadores)
        rvClientes = view.findViewById(R.id.rv_clientes)

        trabajadorAdapter = TrabajadorAdapter(Repositorio.getTrabajadores()) { trabajador ->
            Repositorio.deleteTrabajador(trabajador)
            actualizarListas()
        }

        clienteAdapter = ClienteAdapter(Repositorio.getClientes()) { cliente ->
            Repositorio.deleteCliente(cliente)
            actualizarListas()
        }

        rvTrabajadores.layoutManager = LinearLayoutManager(context)
        rvTrabajadores.adapter = trabajadorAdapter

        rvClientes.layoutManager = LinearLayoutManager(context)
        rvClientes.adapter = clienteAdapter

        btnAddTrabajador.setOnClickListener {
            mostrarDialogoAgregarTrabajador()
        }

        btnAddCliente.setOnClickListener {
            mostrarDialogoAgregarCliente()
        }

        return view
    }

    private fun mostrarDialogoAgregarTrabajador() {
        val dialog = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_agregar_trabajador, null)
        dialog.setView(dialogView)

        val nombreInput = dialogView.findViewById<EditText>(R.id.et_nombre)
        val puestoInput = dialogView.findViewById<EditText>(R.id.et_puesto)

        dialog.setPositiveButton("Agregar") { _, _ ->
            val nombre = nombreInput.text.toString()
            val puesto = puestoInput.text.toString()
            val id = Repositorio.getTrabajadores().size + 1 // Generar ID simple
            val nuevoTrabajador = Trabajador(id, nombre, puesto)
            Repositorio.addTrabajador(nuevoTrabajador)
            actualizarListas()
        }
        dialog.setNegativeButton("Cancelar", null)
        dialog.show()
    }

    private fun mostrarDialogoAgregarCliente() {
        val dialog = AlertDialog.Builder(requireContext())
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_agregar_cliente, null)
        dialog.setView(dialogView)

        val nombreInput = dialogView.findViewById<EditText>(R.id.et_nombre_cliente)
        val correoInput = dialogView.findViewById<EditText>(R.id.et_correo)

        dialog.setPositiveButton("Agregar") { _, _ ->
            val nombre = nombreInput.text.toString()
            val correo = correoInput.text.toString()
            val id = Repositorio.getClientes().size + 1 // Generar ID simple
            val nuevoCliente = Cliente(id, nombre, correo)
            Repositorio.addCliente(nuevoCliente)
            actualizarListas()
        }
        dialog.setNegativeButton("Cancelar", null)
        dialog.show()
    }

    private fun actualizarListas() {
        trabajadorAdapter.notifyDataSetChanged()
        clienteAdapter.notifyDataSetChanged()
    }
}
