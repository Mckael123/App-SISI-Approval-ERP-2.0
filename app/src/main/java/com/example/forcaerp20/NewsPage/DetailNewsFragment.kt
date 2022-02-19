package com.example.forcaerp20.NewsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.forcaerp20.R


class DetailNewsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_news, container, false)
    }

    val args: DetailNewsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val judul = args.judul
        val image = args.image
        val tanggal = args.tanggal
        val isi = args.isi

        var TVjudul = view.findViewById<TextView>(R.id.judul_news)
        var TVimage = view.findViewById<ImageView>(R.id.image_news)
        var TVtanggal = view.findViewById<TextView>(R.id.tanggal_news)
        var TVisi = view.findViewById<TextView>(R.id.isi_news)

        TVjudul.setText(judul)
        TVimage.setImageResource(image)
        TVtanggal.setText(tanggal)
        TVisi.setText(isi)


    }
}