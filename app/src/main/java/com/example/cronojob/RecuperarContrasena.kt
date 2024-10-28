package com.example.cronojob

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ResetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recuperar_contrasena)

        // Configurar padding para bordes del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Captura el nombre de usuario desde el Intent
        val nombreUsuario = intent.getStringExtra("nombre_usuario") ?: ""

        // Inicializar campos de texto y botón
        val etNuevaContrasena: TextInputEditText = findViewById(R.id.etContrasenaNueva)
        val etConfirmarContrasena: TextInputEditText = findViewById(R.id.etConfirmarContrasena)
        val btnReiniciar: MaterialButton = findViewById(R.id.btnReiniciar)

        // Configurar el listener para el botón de reinicio
        btnReiniciar.setOnClickListener {
            val nuevaContrasena = etNuevaContrasena.text.toString().trim()
            val confirmarContrasena = etConfirmarContrasena.text.toString().trim()

            // Validar que los campos no estén vacíos
            if (nuevaContrasena.isNotEmpty() && confirmarContrasena.isNotEmpty()) {
                if (nuevaContrasena == confirmarContrasena) {
                    // Validar longitud mínima de la nueva contraseña
                    if (nuevaContrasena.length >= 6) { // Cambia '6' al número deseado
                        // Actualizar la contraseña en SharedPreferences
                        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                        val editor = sharedPreferences.edit()
                        editor.putString(nombreUsuario, nuevaContrasena) // Actualiza la contraseña del usuario
                        editor.apply()

                        // Notificar al usuario y redirigir al login
                        Toast.makeText(this, "Contraseña cambiada exitosamente", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Login::class.java))
                        finish()
                    } else {
                        // Notificar al usuario si la contraseña es demasiado corta
                        Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Mostrar un mensaje de error si las contraseñas no coinciden
                    etConfirmarContrasena.error = "Las contraseñas no coinciden."
                }
            } else {
                // Mostrar mensajes de error si los campos están vacíos
                if (nuevaContrasena.isEmpty()) {
                    etNuevaContrasena.error = "Por favor, introduce una nueva contraseña."
                }
                if (confirmarContrasena.isEmpty()) {
                    etConfirmarContrasena.error = "Por favor, confirma la nueva contraseña."
                }
            }
        }
    }
}
