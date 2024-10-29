package com.example.proyectopatrones

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopatrones.databinding.EventoItemBinding
import com.example.proyectopatrones.model.Evento // Importamos la clase Evento desde el paquete model

class EventoAdapter(private val context: Context, private val eventos: List<Evento>) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    class EventoViewHolder(val binding: EventoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val binding = EventoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]
        holder.binding.eventoNombre.text = evento.nombre
        holder.binding.eventoFecha.text = evento.fecha
        holder.binding.eventoLugar.text = evento.lugar
        holder.binding.eventoImagen.setImageResource(evento.imagenResId)

        // Configura el botón "Asistir" para abrir AsistirEventoActivity
        holder.binding.asistirEventoButton.setOnClickListener {
            val intent = Intent(context, ConfirmarEventoActivity::class.java)
            // Puedes pasar datos adicionales del evento aquí, si es necesario
            intent.putExtra("eventoNombre", evento.nombre)
            intent.putExtra("eventoFecha", evento.fecha)
            intent.putExtra("eventoLugar", evento.lugar)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return eventos.size
    }
}
