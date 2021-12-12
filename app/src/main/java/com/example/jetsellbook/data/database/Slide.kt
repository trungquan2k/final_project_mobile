package com.example.jetsellbook.data.database


data class Places(
    val title: String,
    val description: String,
    val rating: Float,
    val url: String
)

val places = listOf(
    Places(
        "Tuvalu",
        ".",
        5f,
        "https://i.pinimg.com/originals/f5/25/6f/f5256f22b9dea5d4eb80c41f91f87793.jpg"
    ),
    Places(
        "Los Angles",
        "",
        4.5f,
        "https://tophinhanhdep.com/wp-content/uploads/2021/10/Vietnam-4K-Wallpapers.jpg"
    ),
    Places(
        "China",
        "",
        4.5f,
        "https://p4.wallpaperbetter.com/wallpaper/170/24/4/5c1cbe61b60be-wallpaper-preview.jpg"
    ),
    Places(
        "Tokyo",
        "",
        3.5f,
        "https://tophinhanhdep.com/wp-content/uploads/2021/10/4K-UHD-Wallpapers.jpg"
    ),
    Places(
        "Book tua",
        "",
        4.5f,
        "https://www.setaswall.com/wp-content/uploads/2017/03/4K-Coffee-Book-Glasses-Wallpaper-3840x2160.jpg"
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
