package com.example.mvvmbasicproject.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmbasicproject.R
import com.example.mvvmbasicproject.contract.DetailActivityCon
import com.example.mvvmbasicproject.databinding.ActivityDetailBinding
import com.example.mvvmbasicproject.net.ApiClient
import com.example.mvvmbasicproject.viewModel.DetailActivityVM

class DetailActivity : AppCompatActivity(), DetailActivityCon {
    override fun startBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun showError(message: String) {
        Toast.makeText(this, "error = $message", Toast.LENGTH_SHORT).show()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    val EXTRA_FULL_REPOSITORY_NAME: String = "EXTRA_FULL_REPOSITORY_NAME"

    private var fullName: String = ""

    companion object {
        fun start(context: Context, fullRepositoryName: String) {
            val intent: Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity().EXTRA_FULL_REPOSITORY_NAME, fullRepositoryName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val apiService = ApiClient.getClient()
        binding.detailActivityVM = DetailActivityVM(apiService, this)

        intent?.let {
            fullName = it.getStringExtra(EXTRA_FULL_REPOSITORY_NAME)
            binding.detailActivityVM!!.requestDetailRepo()
        }

    }

    override fun getName(): String {
        return fullName
    }
}