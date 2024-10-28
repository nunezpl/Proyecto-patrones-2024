package com.example.proyectopatrones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectopatrones.service.AuthService

class MainActivity : AppCompatActivity() {

    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var authService: AuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)  // Cambia el layout a activity_inicio_sesion

        // Conectar los campos y botones
        emailField = findViewById(R.id.inicio_sesion_username)
        passwordField = findViewById(R.id.inicio_sesion_password)
        loginButton = findViewById(R.id.inicio_sesion_login_button)

        authService = AuthService()

        // Configurar el botón de inicio de sesión
        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            // Llamar al servicio de autenticación
            if (authService.login(email, password)) {
                // Si la autenticación es correcta
                Toast.makeText(this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show()

                // Redirigir a la pantalla de selección de rol
                val intent = Intent(this, SeleccionRolActivity::class.java)
                startActivity(intent)

                // Finalizar MainActivity para que el usuario no pueda volver atrás
                finish()
            } else {
                // Si la autenticación falla
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
