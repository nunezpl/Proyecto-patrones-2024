package com.example.proyectopatrones.model

data class User(
    val name: String,
    val email: String,
    val password: String,
    var isActive: Boolean
)
