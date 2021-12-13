package com.example.jetsellbook.model



data class BooksModel(
    val id: Int,
    val book_name: String,
    val image: String,
    val price: Int,
    val author:String,
    val description: String,
    val price_promotion:Int,
    val created_at: String,
    val updated_at: String,
)
//{
//    constructor() : this("", "", Ur, "","","","","")
//}
