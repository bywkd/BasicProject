package com.example.mvvmbasicproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.mvvmbasicproject.databinding.ItemSpinnerBinding
import com.example.mvvmbasicproject.viewModel.SpinnerAdapterVM

class SpinnerAdapter : ArrayAdapter<String> {

    private var items: ArrayList<String>
    private var binding: ItemSpinnerBinding

    constructor(context: Context, layout: Int, items: ArrayList<String>) : super(context, layout) {
        this.items = items
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            layout,
            null,
            false
        )
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        binding.spinnerAdapterVM = SpinnerAdapterVM()
        binding.spinnerAdapterVM?.setItemText(items[position])
        return binding.root
    }

    override fun getCount(): Int {
        return items.size
    }

//    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val binding: ItemSpinnerBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(context),
//            android.R.layout.simple_spinner_dropdown_item,
//            null,
//            false
//        )
//
//        binding.spinnerAdapterVM = SpinnerAdapterVM()
//        binding.spinnerAdapterVM?.setItemText(items[position])
//        return binding.root
//    }
}