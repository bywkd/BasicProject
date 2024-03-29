package com.example.mvvmbasicproject.customBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object ImageViewBinding {

    fun loadImgViewRes(imgView: ImageView, resId: Int) {
        imgView.setImageResource(resId)
    }

    @JvmStatic
    @BindingAdapter("loadGlide")
    fun loadGlide(imgView: ImageView, imgUrl: String?) {
        Glide.with(imgView.context).load(imgUrl).into(imgView)
    }
}