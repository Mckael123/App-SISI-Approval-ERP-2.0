package com.example.forcaerp20.DashboardPage.approveFragment

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
import com.example.forcaerp20.DashboardPage.pendingFragment.CategoryPending
import com.example.forcaerp20.DashboardPage.pendingFragment.ListCategoryAdapter
import com.example.forcaerp20.R


class ApprovFragment : Fragment() {

    private lateinit var recylerCategory: RecyclerView
    private lateinit var listCategory: ArrayList<CategoryApproved>

    lateinit var NameCategoryApprov: Array<String>
//    lateinit var CountApprovCategory: Array<Int>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //contoh data
        NameCategoryApprov = arrayOf("AP Payment", "AP Invoice")
//        CountApprovCategory = arrayOf()
        val CountApprovCategory : Array<Int> = arrayOf(3,5)
        listCategory = arrayListOf()

            for (i in NameCategoryApprov.indices) {

                val Category = CategoryApproved()
                Category.NameCategoryApprov = NameCategoryApprov[i]
                Category.CountApprovCategory = CountApprovCategory[i]
                listCategory.add(Category)
            }

            var adapters = ListCategory2Adapter(listCategory)
            recylerCategory = view.findViewById(R.id.category2_list_RecyclerView)
            recylerCategory.layoutManager = LinearLayoutManager(requireActivity())
            recylerCategory.adapter = adapters
            adapters.setOnItemClickListener(object : ListCategory2Adapter.onItemClickListener {
                override fun onItemClick(position: Int) {

                    Navigation.findNavController(view).navigate(R.id.action_approvFragment_to_listApprovedFragment)
                }

            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_approved, container, false)
    }
}