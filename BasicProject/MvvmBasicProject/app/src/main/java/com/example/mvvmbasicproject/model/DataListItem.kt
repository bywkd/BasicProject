package com.example.mvvmbasicproject.model

import com.google.gson.annotations.SerializedName

class DataListItem {
    @SerializedName("items")
    var items: List<DataItem>? = null
}