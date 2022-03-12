package com.example.forcaerp20.DashboardPage.pendingFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forcaerp20.R


class PendingFragment : Fragment() {

    private lateinit var recylerCategory: RecyclerView
    private lateinit var listCategory: ArrayList<CategoryPending>

    lateinit var NameCategory: Array<String>
//    lateinit var CountPendingCategory: Array<Int>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //contoh data
        NameCategory = arrayOf("AP Payment", "AP Invoice")
//        CountPendingCategory = arrayOf()
        val CountPendingCategory : Array<Int> = arrayOf(3,5)
        listCategory = arrayListOf()

        val notifNodocument: TextView = view.findViewById(R.id.NodocumentNotifPending)
        val notifNodocumentDeskrip: TextView = view.findViewById(R.id.NodocumentNotifPendingDeskrip)

        if (CountPendingCategory.isEmpty()) {
            notifNodocument.setText("No Document")
            notifNodocumentDeskrip.setText("There is no document attached ")

        }
        else{

            for (i in NameCategory.indices) {

                val Category = CategoryPending()
                Category.NameCategory = NameCategory[i]
                Category.CountPendingCategory = CountPendingCategory[i]
                listCategory.add(Category)
            }

            var adapters = ListCategoryAdapter(listCategory)
            recylerCategory = view.findViewById(R.id.category_list_RecyclerView)
            recylerCategory.layoutManager = LinearLayoutManager(requireActivity())
            recylerCategory.adapter = adapters
            adapters.setOnItemClickListener(object : ListCategoryAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {

                    Navigation.findNavController(view).navigate(R.id.action_pendingFragment_to_listPendingFragment)
                }

            })

            notifNodocument.setText("")
            notifNodocumentDeskrip.setText("")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendings, container, false)
    }
}