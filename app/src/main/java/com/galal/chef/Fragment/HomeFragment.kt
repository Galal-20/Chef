package com.galal.chef.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView.ScaleType
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.galal.chef.Adapter.PopularAdapter
import com.galal.chef.MenuBottomFragment
import com.galal.chef.R
import com.galal.chef.databinding.FragmentHomeBinding

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

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
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.ViewMore.setOnClickListener {
            val bottomSheetDialog = MenuBottomFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.img,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.img_1,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.searcheng,ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList,ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                Toast.makeText(requireContext(),"Select image $position",Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Burger", "sandwich", "Beef" , "Burger", "sandwich", "Beef")
        val price = listOf("100 EGP", "200 EGP", "150 EGP","100 EGP", "200 EGP", "150 EGP")
        val populerFoodImage = listOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.searcheng,
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.searcheng)
        val adapter = PopularAdapter(foodName,price,populerFoodImage,requireContext())
        binding.recycle.layoutManager = LinearLayoutManager(requireContext())
        binding.recycle.adapter = adapter
    }
    companion object{

    }
}