package com.example.proyectopatrones

import com.example.proyectopatrones.UsuarioActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class SeleccionRolActivity : AppCompatActivity() {

    private lateinit var btnUsuario: Button
    private lateinit var btnAdministrador: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seleccion_rol)

        btnUsuario = findViewById(R.id.btn_usuario)
        btnAdministrador = findViewById(R.id.btn_administrador)

        // Acción cuando seleccionan Usuario
        btnUsuario.setOnClickListener {
            val intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
            finish() // Finaliza la actividad SeleccionRolActivity
        }

        // Acción cuando seleccionan Administrador
        btnAdministrador.setOnClickListener {
            val intent = Intent(this, AdministradorActivity::class.java)
            startActivity(intent)
            finish() // Finaliza la actividad SeleccionRolActivity
        }
    }
}
