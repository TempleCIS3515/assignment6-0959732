package edu.temple.imagedisplayapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {

    lateinit var imageViewModel: ImageViewModel
    private lateinit var textView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false).also {

            textView = it.findViewById(R.id.textView3)
            imageView = it.findViewById(R.id.imageView3)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
                imageViewModel.getSelectedImage().observe(requireActivity())
                {
                    changeImage(it)
                }
    }

    private fun changeImage(image: Image)
    {
        imageView.setImageResource(image.resourceId)
        textView.text = image.description
    }
}
