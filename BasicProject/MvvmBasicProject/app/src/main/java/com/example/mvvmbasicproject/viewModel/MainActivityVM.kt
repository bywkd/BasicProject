package com.example.mvvmbasicproject.viewModel

import android.content.Context
import android.text.format.DateFormat
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.size
import androidx.databinding.ObservableField
import com.example.mvvmbasicproject.contract.MainActivityCon
import com.example.mvvmbasicproject.model.DataItem
import com.example.mvvmbasicproject.model.DataListItem
import com.example.mvvmbasicproject.net.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivityVM {

    private var client: ApiService
    private var contract: MainActivityCon
    val progressVisi: ObservableField<Int> = ObservableField()

    constructor(client: ApiService, contract: MainActivityCon) {
        this.client = client
        this.contract = contract
    }

    fun onSpinnerDropSownItem(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        if (parent.size > 0) {
            requestDataList(parent.context, parent.getItemAtPosition(position).toString())
        }
    }

    private fun requestDataList(context: Context, language: String) {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -7)
        val date = DateFormat.format("yyyy-MM-dd", calendar).toString()

        progressVisi.set(View.VISIBLE)
        client.listRepos("language:$language created:>$date")
            .enqueue(object : Callback<DataListItem> {
                override fun onFailure(call: Call<DataListItem>, t: Throwable) {
                    progressVisi.set(View.GONE)
                    Toast.makeText(context, "requestDataList onFailure", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<DataListItem>,
                    response: Response<DataListItem>
                ) {
                    progressVisi.set(View.GONE)
                    if (response.isSuccessful) {
                        val result = response.body()
                        result?.items?.let {
                            contract.resultDataList(it.toMutableList() as ArrayList<DataItem>)
                        } ?: let {
                            Toast.makeText(
                                context,
                                "requestDataList onResponse",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }

            })
    }
}