package com.example.cronojob.repositorio
import com.example.cronojob.model.Cliente
import com.example.cronojob.model.Trabajador

object Repositorio {
    private val trabajadores = mutableListOf<Trabajador>()
    private val clientes = mutableListOf<Cliente>()

    fun addTrabajador(trabajador: Trabajador) {
        trabajadores.add(trabajador)
    }

    fun getTrabajadores(): List<Trabajador> = trabajadores

    fun deleteTrabajador(trabajador: Trabajador) {
        trabajadores.remove(trabajador)
    }

    fun addCliente(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun getClientes(): List<Cliente> = clientes

    fun deleteCliente(cliente: Cliente) {
        clientes.remove(cliente)
    }
}
