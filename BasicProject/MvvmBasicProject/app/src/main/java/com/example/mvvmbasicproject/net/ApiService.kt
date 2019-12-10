package com.example.mvvmbasicproject.net

import com.example.mvvmbasicproject.model.DataItem
import com.example.mvvmbasicproject.model.DataListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories?sort=stars&order=desc")
    fun listRepos(
        @Query("q") query: String
    ): Call<DataListItem>


    @GET("repos/{repoOwner}/{repoName}")
    fun detailRepo(
        @Path("repoOwner") owner: String,
        @Path("repoName") repoName: String
    ): Call<DataItem>
}