package com.example.cronojob

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cronojob.databinding.ActivityAddTrabajadorBinding
import com.google.android.material.button.MaterialButton

class addTrabajador : AppCompatActivity() {
    private lateinit var binding: ActivityAddTrabajadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_trabajador) // Asegúrate de que este sea el nombre correcto de tu layout

        val btnGuardarTrabajador = findViewById<MaterialButton>(R.id.buttonGuardar) // Asegúrate de que este ID sea correcto
        btnGuardarTrabajador.setOnClickListener {
            // Aquí puedes agregar la lógica para guardar el trabajador antes de redirigir
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres volver a ella
        }
    }
}
