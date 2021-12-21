package com.example.androidtest.Utils

import android.widget.ProgressBar
import com.squareup.picasso.Callback

open class ImageLoadedCallback(var progressBar: ProgressBar) : Callback {
    override fun onSuccess() {}
    override fun onError() {}
}