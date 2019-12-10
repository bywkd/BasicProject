package com.example.mvvmbasicproject.contract

import com.example.mvvmbasicproject.model.DataItem

interface MainActivityCon {
    fun resultDataList(dataList: ArrayList<DataItem>)
    fun startActivityDetail(fullName: String)
}