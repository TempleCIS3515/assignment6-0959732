package edu.temple.imagedisplayapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    val selectedimage : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun setSelectedImage(image: Item) {
        selectedimage.value = image.toString()
    }

    fun getSelectedImage() : LiveData<String> {
        return selectedimage
    }
}