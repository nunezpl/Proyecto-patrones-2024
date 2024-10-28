package com.example.proyectopatrones

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectopatrones.databinding.AlojamientoItemBinding
import com.example.proyectopatrones.model.Alojamiento


class AlojamientoAdapter(private val alojamientos: List<Alojamiento>) : RecyclerView.Adapter<AlojamientoAdapter.AlojamientoViewHolder>() {

    class AlojamientoViewHolder(val binding: AlojamientoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlojamientoViewHolder {
        val binding = AlojamientoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlojamientoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlojamientoViewHolder, position: Int) {
        val alojamiento = alojamientos[position]
        holder.binding.alojamientoNombre.text = alojamiento.nombre
        holder.binding.alojamientoFecha.text = alojamiento.fecha
        holder.binding.alojamientoImagen.setImageResource(alojamiento.imagenResId)
        holder.binding.alojamientoTipo.text = alojamiento.tipo
        holder.binding.alojamientoPrecio.text = alojamiento.precio
    }

    override fun getItemCount(): Int {
        return alojamientos.size
    }
}
