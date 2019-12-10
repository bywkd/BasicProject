package com.example.mvvmbasicproject.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmbasicproject.R
import com.example.mvvmbasicproject.contract.MainActivityCon
import com.example.mvvmbasicproject.databinding.ItemDataBinding
import com.example.mvvmbasicproject.model.DataItem
import com.example.mvvmbasicproject.viewModel.DataListAdapterVM

class DataListAdapter : RecyclerView.Adapter<DataListAdapter.DataListViewHolder> {

    private var contract: MainActivityCon
    private var dataList: ArrayList<DataItem> = arrayListOf()
    private val context: Context

    constructor(context: Context, contract: MainActivityCon) {
        this.context = context
        this.contract = contract
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val binding: ItemDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_data, parent, false)
        binding.dataListAdapterVM = DataListAdapterVM(contract)
        return DataListViewHolder(binding.root, binding.dataListAdapterVM!!)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.onBind(dataList[holder.adapterPosition])
    }

    fun setDataList(list: ArrayList<DataItem>) {
        if (dataList.size > 0) {
            dataList.clear()
        }
        dataList.addAll(list)
        notifyDataSetChanged()
    }


    class DataListViewHolder : RecyclerView.ViewHolder {
        private val dataListAdapterVM: DataListAdapterVM

        constructor(
            view: View,
            dataListAdapterVM: DataListAdapterVM
        ) : super(view) {
            this.dataListAdapterVM = dataListAdapterVM
        }

        fun onBind(dataList: DataItem) {
            dataListAdapterVM.setData(dataList)
        }
    }
}