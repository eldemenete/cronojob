package com.example.cronojob

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cronojob.databinding.ActivityAddClienteBinding
import com.google.android.material.button.MaterialButton

class addCliente : AppCompatActivity() {
    private lateinit var binding: ActivityAddClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cliente) // Asegúrate de que este sea el nombre correcto de tu layout

        val btnIngresarClient = findViewById<MaterialButton>(R.id.buttonGuardar)
        btnIngresarClient.setOnClickListener {
            // Aquí puedes agregar la lógica para guardar el cliente antes de redirigir
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres volver a ella
        }
    }
}