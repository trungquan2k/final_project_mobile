package com.example.jetsellbook.model

data class BookCategory(
    val id: Long = 0,
    val book_type: String="",
    val image: String="",
    val description: String=""
)

val DEFAULT_BOOKTYPE = listOf<BookCategory>(
    BookCategory(
        1,
        "Sách truyện ma",
        "https://top.trangdangtin.com/htdocs/images/news/2021/03/10/800/webp/60483f2f0cebb_h5mpp2d.webp",
        "Sach hay",
    ),
    BookCategory(
        2,
        "Sách lãng mạn",
        "https://readvii.com/wp-content/uploads/2020/04/sach-lang-man-cover.png",
        "Hoang Trung Quan",
    ),
    BookCategory(
        3,
        "Sách cuộc sống",
        "https://cdn.chanhtuoi.com/uploads/2019/05/w400/nhung-cau-noi-hay-ve-cuoc-song-14.jpg.webp",
        "Hoang Trung Quan",
    ),
    BookCategory(
        4,
        "Sách kỷ năng",
        "https://img.timviec.com.vn/2020/02/ky-nang-la-gi-2.jpg",
        "Hoang Trung Quan",
    ),
)