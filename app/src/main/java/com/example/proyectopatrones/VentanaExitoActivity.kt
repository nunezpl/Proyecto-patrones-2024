package com.example.proyectopatrones

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectopatrones.databinding.VentanaExitoBinding

class VentanaExitoActivity : AppCompatActivity() {
    private lateinit var binding: VentanaExitoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VentanaExitoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del Intent si necesitas mostrar detalles específicos de la reserva
        val eventoFecha = intent.getStringExtra("eventoFecha") ?: "Fecha no disponible"
        val eventoLugar = intent.getStringExtra("eventoLugar") ?: "Lugar no disponible"
        val eventoHora = intent.getStringExtra("eventoHora") ?: "Hora no disponible"
        val token = intent.getStringExtra("token") ?: "00000072697027"

        // Asignar los datos a los TextViews correspondientes
        binding.date.text = eventoFecha
        binding.place.text = eventoLugar
        binding.time.text = eventoHora
        binding.token.text = token

        // Botón para cerrar la pantalla de confirmación
        binding.botonSalir.setOnClickListener {
            finish()  // Cierra esta actividad y regresa a la anterior
        }
    }
}