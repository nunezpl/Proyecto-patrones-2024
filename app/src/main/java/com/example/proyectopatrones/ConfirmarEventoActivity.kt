package com.example.proyectopatrones

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectopatrones.databinding.ConfirmaPageBinding

class ConfirmarEventoActivity : AppCompatActivity() {

    private lateinit var binding: ConfirmaPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ConfirmaPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del evento del Intent
        val eventoNombre = intent.getStringExtra("eventoNombre") ?: "Nombre no disponible"
        val eventoFecha = intent.getStringExtra("eventoFecha") ?: "Fecha no disponible"
        val eventoLugar = intent.getStringExtra("eventoLugar") ?: "Lugar no disponible"

        // Asignar los datos a los elementos de la interfaz
        binding.nombreEvento.text = eventoNombre
        binding.ubicacion.text = eventoLugar
        binding.fecha.text = eventoFecha

        // Configuración adicional si es necesario, como un listener para el botón de reservar
        binding.botonReservar.setOnClickListener {
            // Crear Intent para abrir la actividad de confirmación
            val intent = Intent(this, VentanaExitoActivity::class.java)

            // Pasar los datos necesarios a la actividad de confirmación
            intent.putExtra("eventoFecha", eventoFecha)
            intent.putExtra("eventoLugar", eventoLugar)
            intent.putExtra("eventoHora", "18:00") // Ejemplo de hora
            intent.putExtra("token", "00000072697027") // Ejemplo de token único

            // Iniciar la actividad de confirmación
            startActivity(intent)
        }

    }

}