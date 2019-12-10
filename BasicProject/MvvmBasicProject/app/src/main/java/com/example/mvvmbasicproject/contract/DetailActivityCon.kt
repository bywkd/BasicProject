package com.example.mvvmbasicproject.contract

interface DetailActivityCon {
    fun getName(): String
    fun startBrowser(url: String)
    fun showError(message: String)
    fun showToast(message:String)
}