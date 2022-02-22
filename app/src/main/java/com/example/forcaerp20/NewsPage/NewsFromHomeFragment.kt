package com.example.forcaerp20.NewsPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.R


class NewsFromHomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    private lateinit var rvItem: RecyclerView
    private lateinit var list: ArrayList<Item>


    lateinit var judul: Array<String>
    lateinit var image: Array<Int>
    lateinit var tanggal: Array<String>
    lateinit var isi: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //contoh data

        judul = arrayOf(
            "Untuk Operasional Bisnis yang Lebih Baik, Pertimbangkan Pemanfaatan Berbagai Aplikasi Ini",
            "Wujudkan Resolusi Bisnis Tahun Ini dengan Dukungan Sistem ERP",
            "Memahami Penerapan ERP Pada Bisnis, Mahasiswa UISI Gelar Webinar bersama SISI"
        )
        image = arrayOf(
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3
        )
        tanggal = arrayOf(
            "17 January 2022",
            "18 January 2022",
            "19 January 2022",

            )
        isi = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c)

        )

        rvItem = view.findViewById(R.id.item_list_RecyclerView)
        rvItem.layoutManager = LinearLayoutManager(requireActivity())
//        rvItem.setHasFixedSize(true)

        list = arrayListOf()
        for (i in image.indices) {

            val news = Item()
            news.judul = judul[i]
            news.image = image[i]
            news.tanggal = tanggal[i]
            news.isi = isi[i]
            list.add(news)
        }


//        list.addAll(ItemData.listData)
        var adapter = ItemAdapter(list)
        rvItem.adapter = adapter

        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                //pake navigate safe Args

                val action = NewsFromHomeFragmentDirections.actionNewsFromHomeFragmentToDetailNewsFragment(
                    judul= list[position].judul,
                    image=list[position].image,
                    tanggal=list[position].tanggal,
                    isi=list[position].isi
                )
                Navigation.findNavController(view).navigate(action)
            }
        })


    }

}