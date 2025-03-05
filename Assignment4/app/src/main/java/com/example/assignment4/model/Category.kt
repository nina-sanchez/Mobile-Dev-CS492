package com.example.assignment4.model

data class Category(
    val name: Int,
    val recommendations: List<Recommendation>,
    val iconResourceId: Int
)