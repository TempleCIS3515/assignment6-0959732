package edu.temple.imagedisplayapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    val selectedimage : MutableLiveData<Image> by lazy {
        MutableLiveData<Image>()
    }

    fun setSelectedImage(image: Image) {
        selectedimage.value = image
    }

    fun getSelectedImage() : LiveData<Image> {
        return selectedimage
    }
}