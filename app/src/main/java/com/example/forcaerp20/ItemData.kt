package com.example.forcaerp20


object ItemData {

    private val title_news = arrayOf(
        "Untuk Operasional Bisnis yang Lebih Baik, Pertimbangkan Pemanfaatan Berbagai Aplikasi Ini",
        "Wujudkan Resolusi Bisnis Tahun Ini dengan Dukungan Sistem ERP",
        "Memahami Penerapan ERP Pada Bisnis, Mahasiswa UISI Gelar Webinar bersama SISI"
    )
    private val foto = arrayOf(
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3
    )
    private val tanggal = arrayOf(
        "17 January 2022",
        "18 January 2022",
        "19 January 2022",

        )
    private val isi = arrayOf(
        R.string.news_a,
        R.string.news_b,
        R.string.news_c

    )

    val listData: ArrayList<Item>
        get() {
            val list = arrayListOf<Item>()
            for (position in title_news.indices) {
                val item = Item()
                item.judul = title_news[position]
                item.tanggal = tanggal[position]
                item.foto = foto[position]
                item.isi = isi[position].toString()
                list.add(item)
            }
            return list
        }

}