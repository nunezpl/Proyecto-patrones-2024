package com.example.proyectopatrones.service

class AuthService {

    // Este método es para validar el inicio de sesión
    fun login(email: String, password: String): Boolean {
        // Aquí sé valida desde una base de datos, pero por ahora con datos quemados
        return email == "usuario@ejemplo.com" && password == "1234"
    }
}