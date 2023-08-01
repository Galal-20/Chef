package com.galal.chef

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.galal.chef.Adapter.CartAdapter
import com.galal.chef.Adapter.MenuAdapter
import com.galal.chef.databinding.FragmentMenuBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomFragment : BottomSheetDialogFragment() {

    lateinit var binding: FragmentMenuBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomBinding.inflate(inflater,container,false)

        binding.backButton.setOnClickListener{ dismiss()}

        val menuFoodName = listOf("Burger", "Salad", "Beef" , "Burger", "Salad", "Salmon",
            "Burger", "Salad", "Beef" , "Burger", "Salad", "Salmon")
        val menuPrice = listOf("100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP",
            "100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP")
        val cartImage = listOf(
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
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuPrice),ArrayList(cartImage),requireContext())
        binding.recycleMenuItem.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleMenuItem.adapter = adapter

        return binding.root
    }

    companion object {

    }
}