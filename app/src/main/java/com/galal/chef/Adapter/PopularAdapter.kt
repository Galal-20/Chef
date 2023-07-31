package com.galal.chef.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galal.chef.DetailsActivity
import com.galal.chef.databinding.PopularBinding

class PopularAdapter (
    private val Items:List<String>,
    private val price:List<String>,
    private val image:List<Int>,
    private val requireC: Context): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){

    private val itemClickListener: MenuAdapter.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularBinding.inflate(LayoutInflater.from(parent.context),
        parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = Items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }

    override fun getItemCount(): Int {
        return Items.size
    }

   inner class PopularViewHolder (private val binding: PopularBinding) : RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                Intent(requireC, DetailsActivity::class.java).also {
                    it.putExtra("MenuItemName", Items.get(position))
                    it.putExtra("MenuItemImage", image.get(position))
                    requireC.startActivity(it)
                }
            }
        }

        val imagesView = binding.imageView5
        fun bind(item:String, price:String ,images:Int){
            binding.FoodName.text = item
            binding.price.text = price
            imagesView.setImageResource(images)

        }
    }
    interface OnClickListener
    {
        fun onItemClick(position: Int)
    }
}