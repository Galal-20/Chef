package com.galal.chef.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galal.chef.DetailsActivity
import com.galal.chef.StartActivity
import com.galal.chef.databinding.MenuItemBinding

class MenuAdapter(
    private val menuItem:MutableList<String>,
    private val menuItemPrice:MutableList<String>,
    private val menuItemImage:MutableList<Int>,
    private val reqContext:Context):RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){


    private val itemClickListener:OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int { return menuItem.size }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener?.onItemClick(position)
                }
                Intent(reqContext, DetailsActivity::class.java).also {
                    it.putExtra("MenuItemName", menuItem.get(position))
                    it.putExtra("MenuItemImage", menuItemImage.get(position))
                    reqContext.startActivity(it)
                }
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menuFoodName.text = menuItem[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(menuItemImage[position])


                }
            }
    }

    interface OnClickListener
    {
        fun onItemClick(position: Int)
    }
}

