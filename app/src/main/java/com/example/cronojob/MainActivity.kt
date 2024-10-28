package com.example.cronojob


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cronojob.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddTrabajador.setOnClickListener {
            startActivity(Intent(this, addTrabajador::class.java))
        }

        binding.btnAddCliente.setOnClickListener {
            startActivity(Intent(this, addCliente::class.java))
        }
    }
}
