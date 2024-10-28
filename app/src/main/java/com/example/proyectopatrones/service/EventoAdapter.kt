package com.example.proyectopatrones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopatrones.databinding.EventoItemBinding
import com.example.proyectopatrones.model.Evento // Importamos la clase Evento desde el paquete model

class EventoAdapter(private val eventos: List<Evento>) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    class EventoViewHolder(val binding: EventoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val binding = EventoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.binding.eventoNombre.text = evento.nombre
        holder.binding.eventoFecha.text = evento.fecha
        holder.binding.eventoImagen.setImageResource(evento.imagenResId)
    }

    override fun getItemCount(): Int {
        return eventos.size
    }
}
