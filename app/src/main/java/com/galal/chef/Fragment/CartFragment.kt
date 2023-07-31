package com.galal.chef.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.galal.chef.Adapter.CartAdapter
import com.galal.chef.PayOutActivity
import com.galal.chef.R
import com.galal.chef.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("Burger", "sandwich", "Beef" , "Burger", "sandwich", "Beef")
        val cartItemPrice = listOf("100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP")
        val cartImage = listOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.searcheng,
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.searcheng)
        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.CartRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.CartRecycleView.adapter = adapter

        binding.proceedButton.setOnClickListener {
            Intent(requireContext(),PayOutActivity::class.java).also {
                startActivity(it)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
    }
}