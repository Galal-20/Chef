package com.galal.chef

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.galal.chef.Adapter.NotificationAdapter
import com.galal.chef.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentNotificationBottomBinding

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
        binding = FragmentNotificationBottomBinding.inflate(inflater,container,false)
        val notification = listOf("Your order has been Cancelled Successfully",
            "Order has been taken by the driver",
            "Congrats your order placed")
        val notificationImage = listOf(R.drawable.sad,R.drawable.delivery,R.drawable.tick)
        val adapter = NotificationAdapter(ArrayList(notification), ArrayList(notificationImage))
        binding.recycleNot.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleNot.adapter = adapter
        return binding.root
    }

    companion object {
    }
}