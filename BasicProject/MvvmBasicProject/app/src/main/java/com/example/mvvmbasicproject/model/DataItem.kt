package com.example.mvvmbasicproject.model

import com.google.gson.annotations.SerializedName

class DataItem {
    @SerializedName("description")
    var description: String = ""
    @SerializedName("owner")
    var owner: Owner? = null
    @SerializedName("language")
    var language: String = ""
    @SerializedName("name")
    var name: String = ""
    @SerializedName("stargazers_count")
    var stargazersCount: String = ""
    @SerializedName("forks_count")
    var forksCount: String = ""
    @SerializedName("full_name")
    var fullName: String = ""
    @SerializedName("html_url")
    var htmlUrl: String = ""
}