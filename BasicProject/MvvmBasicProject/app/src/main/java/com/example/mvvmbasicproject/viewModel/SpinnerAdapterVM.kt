package com.example.mvvmbasicproject.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class SpinnerAdapterVM : ViewModel() {

    val spinnerItemText: ObservableField<String> = ObservableField()

    fun setItemText(text: String) {
        spinnerItemText.set(text)
    }
}