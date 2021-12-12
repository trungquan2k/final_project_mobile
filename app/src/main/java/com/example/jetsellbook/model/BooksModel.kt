package com.example.jetsellbook.model

import android.net.Uri

data class BooksModel(
    val id: String,
    val book_name: String,
    val image: String,
    val price: String,
    val author:String,
    val price_promotion:String,
    val created_at: String,
    val updated_at: String,
)
//{
//    constructor() : this("", "", Ur, "","","","","")
//}
