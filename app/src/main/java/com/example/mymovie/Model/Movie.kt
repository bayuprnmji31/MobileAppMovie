package com.example.mymovie.Model

import com.example.mymovie.R

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val imageResId: Int
)

val movieList = listOf(
    Movie(id = 1, title = "Onde Mande", description = "Film komedi yang penuh dengan kelucuan dan kejadian tak terduga, dijamin membuat penonton tertawa terbahak-bahak.", category = "Komedi", imageResId = R.drawable.mv1),
    Movie(id = 2, title = "Arsitektur", description = "Kisah romantis yang menggambarkan cinta di tengah keindahan dunia arsitektur yang penuh tantangan.", category = "Romansa", imageResId = R.drawable.mv2),
    Movie(id = 3, title = "Kuasa Gelap", description = "Film horor yang mengisahkan tentang kekuatan jahat yang merasuki sebuah desa, membawa kengerian bagi penduduknya.", category = "Horor", imageResId = R.drawable.mv3),
    Movie(id = 4, title = "Bom Jakarta", description = "Aksi yang menegangkan saat tim khusus berusaha menghentikan ancaman bom di tengah kota Jakarta.", category = "Aksi", imageResId = R.drawable.mv4),
    Movie(id = 5, title = "Sijjin", description = "Sebuah film horor yang mencekam, terinspirasi dari kisah nyata tentang ritual jahat yang membawa malapetaka.", category = "Horor", imageResId = R.drawable.mv5),
    Movie(id = 6, title = "Indigo", description = "Cerita horor tentang seorang anak indigo yang memiliki kemampuan melihat makhluk tak kasat mata dan menghadapi bahaya besar.", category = "Horor", imageResId = R.drawable.mv6),
    Movie(id = 7, title = "172 Hari", description = "Romansa yang menyentuh hati, menggambarkan kisah cinta yang tumbuh selama 172 hari penuh emosi dan tantangan.", category = "Romansa", imageResId = R.drawable.mv7),
    Movie(id = 8, title = "Quantum", description = "Film aksi penuh ketegangan, mengikuti petualangan seorang agen rahasia dalam misinya untuk menyelamatkan dunia.", category = "Aksi", imageResId = R.drawable.mv8),
    Movie(id = 9, title = "Mariposa", description = "Sebuah film romansa yang manis dan menyentuh hati tentang perjuangan cinta yang penuh pengorbanan dan kejujuran.", category = "Romansa", imageResId = R.drawable.mv9),
    Movie(id = 10, title = "Godzilla Kong", description = "Pertarungan epik antara dua makhluk raksasa legendaris dalam aksi yang penuh ledakan dan adrenalin.", category = "Aksi", imageResId = R.drawable.mv10)
)

