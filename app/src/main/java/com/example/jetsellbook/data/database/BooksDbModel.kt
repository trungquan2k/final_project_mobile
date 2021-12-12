package com.example.jetsellbook.data.database


const val BOOK_PRICE = 1

data class BooksDbModel(
    val id: Long = 0,
    val bookName: String="",
    val image: String="",
    val price: Int=BOOK_PRICE,
    val author: String="",
    val isInWishList: Boolean? = null,
)
val DEFAULT_BOOKS = listOf(
    BooksDbModel(
        1,
        "Sách đường may",
        "https://cuahang.revisach.com/wp-content/uploads/2021/03/sach-duong-may-qua-xu-tuyet.png",
        120000,
        "Hoang Trung Quan",
        false
    ),
    BooksDbModel(
        2,
        "Đời ngắn đừng ngủ",
        "https://cdn.chanhtuoi.com/uploads/2018/05/nhung-cuon-sach-hay-6.jpg.webp",
        120000,
        "Hoang Trung Quan",
        false
    ),
    BooksDbModel(
        3,
        "Đời ngắn đừng ngủ",
        "https://cdn.chanhtuoi.com/uploads/2018/05/nhung-cuon-sach-hay-6.jpg.webp",
        120000,
        "Hoang Trung Quan",
        false
    ),
    BooksDbModel(
        4,
        "Đời ngắn đừng ngủ",
        "https://cdn.chanhtuoi.com/uploads/2018/05/nhung-cuon-sach-hay-6.jpg.webp",
        120000,
        "Hoang Trung Quan",
        false
    ),
    BooksDbModel(
        5,
        "Đời ngắn đừng ngủ",
        "https://cdn.chanhtuoi.com/uploads/2018/05/nhung-cuon-sach-hay-6.jpg.webp",
        120000,
        "Hoang Trung Quan",
        false
    ),
)