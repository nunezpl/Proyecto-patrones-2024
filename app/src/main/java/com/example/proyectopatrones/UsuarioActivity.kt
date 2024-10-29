package com.example.proyectopatrones

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.example.proyectopatrones.databinding.ActivityUsuarioBinding
import com.example.proyectopatrones.model.Evento
import com.example.proyectopatrones.model.Alojamiento

class UsuarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsuarioBinding
    private lateinit var eventoAdapter: EventoAdapter
    private lateinit var alojamientoAdapter: AlojamientoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar listas de eventos y alojamientos
        val eventos = listOf(
            Evento("Concierto de la esperanza", "Sept 20 2024", "Movistar arena", R.drawable.evento1),
            Evento("Concierto Enanitos verdes", "Oct 31 2024", "Campin", R.drawable.evento2),
            Evento("Festival de Jazz", "Nov 15 2024", "Teatro Colón", R.drawable.evento1),
            Evento("Rock al Parque", "Dec 1 2024", "Simón Bolívar", R.drawable.evento2),
            Evento("Feria del Libro", "Apr 20 2025", "Corferias", R.drawable.evento1),
            Evento("Exposición de Arte", "May 5 2025", "Museo Nacional", R.drawable.evento2)
        )

        val alojamientos = listOf(
            Alojamiento("Apartamento en Cartagena", "Sept 10-13", R.drawable.alojamiento1, "Beach", "$50.000/night"),
            Alojamiento("Apartment in San Jose", "Oct 12-20", R.drawable.alojamiento2, "Beach", "$45.000/night")
        )

        // Configurar los adapters
        eventoAdapter = EventoAdapter(this, eventos)
        alojamientoAdapter = AlojamientoAdapter(alojamientos)

        binding.recyclerEventos.layoutManager = LinearLayoutManager(this)
        binding.recyclerEventos.adapter = eventoAdapter // Inicialmente mostrar eventos

        // Agregar las pestañas dinámicamente
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Eventos"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Alojamientos"))

        // Configurar el TabLayout para cambiar entre eventos y alojamientos
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> binding.recyclerEventos.adapter = eventoAdapter // Mostrar eventos
                    1 -> binding.recyclerEventos.adapter = alojamientoAdapter // Mostrar alojamientos
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}
