package com.example.mvvmbasicproject.viewModel

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.mvvmbasicproject.contract.DetailActivityCon
import com.example.mvvmbasicproject.model.DataItem
import com.example.mvvmbasicproject.net.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivityVM(apiService: ApiService, contract: DetailActivityCon) :
    ViewModel() {

    private val apiService = apiService
    private val contract = contract
    private var htmlUrl: String = ""
    val ownerImgUrl: ObservableField<String> = ObservableField()
    val fullName: ObservableField<String> = ObservableField()
    val detail: ObservableField<String> = ObservableField()
    val star: ObservableField<String> = ObservableField()
    val fork: ObservableField<String> = ObservableField()

    fun setData(data: DataItem) {
        htmlUrl = data.htmlUrl
        ownerImgUrl.set(data.owner!!.avatarUrl)
        fullName.set(data.name)
        detail.set(data.description)
        star.set(data.stargazersCount)
        fork.set(data.forksCount)
    }

    fun onOwnerImage(view: View) {
        try {
            contract.startBrowser(htmlUrl)
        } catch (e: Exception) {
            contract.showError("링크를 열 수 없습니다.")
        }
    }

    fun requestDetailRepo() {
        val fullRepoName = contract.getName()
        val repoData = fullRepoName.split("/")
        val owner = repoData[0]
        val repoName = repoData[1]
        apiService.detailRepo(owner, repoName)
            .enqueue(object : Callback<DataItem> {
                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    contract.showToast("detailRepo onFailure")

                }

                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    contract.showToast("detailRepo onResponse")
                    if (response.isSuccessful) {
                        val result = response.body()
                        result?.let {
                            setData(it)
                        }
                    }
                }
            })
    }
}