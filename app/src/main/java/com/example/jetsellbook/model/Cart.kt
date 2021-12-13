package com.example.jetsellbook.model

data class Cart(
    val id: Int,
    val book_name: String,
    val image: String,
    val total: Int,
)