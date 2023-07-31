package com.galal.chef.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galal.chef.databinding.CartItemBinding
import java.nio.file.Files.delete

class CartAdapter(private val cartItem:MutableList<String>,
                  private val cartItemPrice:MutableList<String>,
                  private val cartImage:MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    private var itemQuantities = IntArray(cartItem.size){1}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CartViewHolder(private val binding: CartItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                CartFoodName.text = cartItem[position]
                CartItemPrice.text = cartItemPrice[position]
                CartImage.setImageResource(cartImage[position])
                CartItemQuantity.text = quantity.toString()

                miniButton.setOnClickListener {
                    if (itemQuantities[position] > 1) {
                        itemQuantities[position]--
                        binding.CartItemQuantity.text = itemQuantities[position].toString()
                    }
                }

                plusButton.setOnClickListener {
                    if (itemQuantities[position]<100){
                        itemQuantities[position]++
                        binding.CartItemQuantity.text = itemQuantities[position].toString()
                    }
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        cartItem.removeAt(position)
                        cartItemPrice.removeAt(position)
                        cartImage.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeRemoved(position,cartItem.size)
                    }
                }
            }
        }
    }
}