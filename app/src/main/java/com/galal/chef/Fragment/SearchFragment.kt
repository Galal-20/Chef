package com.galal.chef.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.galal.chef.Adapter.MenuAdapter
import com.galal.chef.R
import com.galal.chef.databinding.FragmentSearchBinding

@SuppressLint("NotifyDataSetChanged")
class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    private val originalMenuFoodName = listOf("Burger", "Salad", "Beef" , "Burger", "Salad", "Salmon"
    ,"Burger", "Salad", "Beef" , "Burger", "Salad", "Salmon")
    private val originalPrice = listOf("100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP",
        "100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP")
    private val originalImage = listOf(
        R.drawable.berger,
        R.drawable.salad,
        R.drawable.salamon,
        R.drawable.berger,
        R.drawable.salad,
        R.drawable.salamon,
        R.drawable.berger,
        R.drawable.salad,
        R.drawable.salamon,
        R.drawable.berger,
        R.drawable.salad,
        R.drawable.salamon)
    private lateinit var adapter: MenuAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuItemPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filterMenuFoodName,filterMenuItemPrice,filterMenuImage,requireContext())
        binding.recycleSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleSearch.adapter = adapter

        //search bar:
        searchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        filterMenuFoodName.addAll(originalMenuFoodName)
        filterMenuItemPrice.addAll(originalPrice)
        filterMenuImage.addAll(originalImage)

        adapter.notifyDataSetChanged()
    }

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object :android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuItemPrice.clear()
        filterMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)){
                filterMenuFoodName.add(foodName)
                filterMenuItemPrice.add(originalPrice[index])
                filterMenuImage.add(originalImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    // companion object {}
}