package com.example.mvvmbasicproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmbasicproject.adapter.DataListAdapter
import com.example.mvvmbasicproject.adapter.SpinnerAdapter
import com.example.mvvmbasicproject.contract.MainActivityCon
import com.example.mvvmbasicproject.databinding.ActivityMainBinding
import com.example.mvvmbasicproject.model.DataItem
import com.example.mvvmbasicproject.net.ApiClient
import com.example.mvvmbasicproject.view.DetailActivity
import com.example.mvvmbasicproject.viewModel.MainActivityVM

class MainActivity : AppCompatActivity(), MainActivityCon {
    override fun startActivityDetail(fullName: String) {
        DetailActivity.start(this, fullName)
    }

    override fun resultDataList(dataList: ArrayList<DataItem>) {
        dataListAdapter?.setDataList(dataList)
    }

    private var dataListAdapter: DataListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val client = ApiClient.getClient()

        binding.mainActivityVM = MainActivityVM(client, this)

        with(binding) {
            setSpinner(this)
            setRcView(this)
        }
    }

    private fun setSpinner(binding: ActivityMainBinding) {
        val itemsLabel = arrayListOf<String>("c", "java", "swift")
        val adapter = SpinnerAdapter(this, R.layout.item_spinner, itemsLabel)
        adapter.addAll(itemsLabel)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLanguage.adapter = adapter
    }

    private fun setRcView(binding: ActivityMainBinding) {
        dataListAdapter = DataListAdapter(this, this)
        binding.rcViewMain.layoutManager = LinearLayoutManager(this)
        binding.rcViewMain.adapter = dataListAdapter
    }
}
