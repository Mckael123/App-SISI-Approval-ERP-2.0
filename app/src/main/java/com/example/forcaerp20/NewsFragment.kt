package com.example.forcaerp20


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NewsFragment : Fragment() {

    private lateinit var rvItem: RecyclerView
    private var list: ArrayList<Item> = arrayListOf()

    lateinit var imageId :Array<Int>
    lateinit var judul: Array<String>
    lateinit var tanggal: Array<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvItem = view.findViewById(R.id.item_list_RecyclerView)
        rvItem.layoutManager= LinearLayoutManager(requireActivity())
        rvItem.setHasFixedSize(true)

        list.addAll(ItemData.listData)
        var adapter = ItemAdapter(list)
        rvItem.adapter= adapter
        adapter.setOnItemClickListener(object:ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //pake navigate safe Args
                val action = NewsFragmentDirections.navigateToDetailNews("namaewa")
                Navigation.findNavController(view).navigate(action)
            }
        })


    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


}