package com.example.jetsellbook.model


data class Places(
    val title: String,
    val description: String,
    val rating: Float,
    val url: String
)

val places = listOf(
    Places(
        "Voucher 2021",
        ".",
        5f,
        "https://i1.wp.com/ditadi.net/wp-content/uploads/2020/03/m%C3%A3-qu%C3%A0-t%E1%BA%B7ng-shopee-l%C3%A0-g%C3%AC.jpg?resize=640%2C351&ssl=1"
    ),
    Places(
        "Gif 100k",
        "",
        4.5f,
        "https://baobibigsun.com/wp-content/uploads/2021/01/voucher.png"
    ),
    Places(
        "China",
        "",
        4.5f,
        "https://www.sony.com.vn/image/bc6d25fa6371c2899ce704a2bed7614c?fmt=png-alpha&wid=720"
    ),
    Places(
        "99K",
        "",
        3.5f,
        "https://a.ipricegroup.com/media/Ed/Coupons/Fahasa.jpg"
    ),
    Places(
        "Tri ân",
        "",
        4.5f,
        "https://img.kam.vn/images/414x0/49e037880c6e4d6cb32686e544d29119/image/fahasa-uu-dai-tri-an-20-11-giam-15-cung-voucher-giam-50.jpg"
    ),
    Places(
        "Books",
        "",
        4.5f,
        "https://wallpaperaccess.com/full/124378.jpg"
    ),
    Places(
        "Chioggia",
        "",
        3.5f,
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJJHYrPcs89QaYbFtWkxPTFgGdg3tX9GW0ipOfPeRwVAobeBFQN3s30eka0UXpCraWLww&usqp=CAU"
    )
)
