package com.example.mvvmbasicproject.viewModel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mvvmbasicproject.contract.MainActivityCon
import com.example.mvvmbasicproject.model.DataItem

class DataListAdapterVM(contract: MainActivityCon) : ViewModel() {

    private var fullName: String = ""
    val name: ObservableField<String> = ObservableField()
    val detail: ObservableField<String> = ObservableField()
    val star: ObservableField<String> = ObservableField()
    val imgUrl: ObservableField<String> = ObservableField()

    private var contract = contract
    fun setData(dataItem: DataItem) {
        fullName = dataItem.fullName
        name.set(dataItem.name)
        detail.set(dataItem.description)
        star.set(dataItem.stargazersCount)
        imgUrl.set(dataItem.owner!!.avatarUrl)
    }

    fun onClick(item: View) {
        contract.startActivityDetail(fullName)
    }
}