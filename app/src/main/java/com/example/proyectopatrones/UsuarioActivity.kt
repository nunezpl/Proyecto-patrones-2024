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
            Evento("Concierto de la esperanza", "Sept 20", R.drawable.evento1),
            Evento("Concierto Enanitos verdes", "Ago 31", R.drawable.evento2)
        )

        val alojamientos = listOf(
            Alojamiento("Apartamento en Cartagena", "Sept 10-13", R.drawable.alojamiento1, "Beach", "$50.000/night"),
            Alojamiento("Apartment in San Jose", "Oct 12-20", R.drawable.alojamiento2, "Beach", "$45.000/night")
        )

        // Configurar los adapters
        eventoAdapter = EventoAdapter(eventos)
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
