package edu.temple.imagedisplayapp

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.imagedisplayapp.MainActivity.Companion.ITEM_KEY

class SelectionFragment : Fragment() {

    private var image: Array<Item>? = null
    private lateinit var imageViewModel: ImageViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)

        arguments?.let {
            image = it.getParcelableArray(ITEM_KEY) as Array<Item>
            image = it.getStringArray(ITEM_KEY) as Array<Item>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = GridLayoutManager(this, 3)
            recyclerView.adapter = ImageAdapter(items, clickEvent)

        with (view as RecyclerView) {
            image?.run {
                val clickEvent = {
                        image:Image -> ImageViewModel.setSelectedImage(image)
                }
                //layoutManager = GridLayoutManager(requireContext())
                //adapter = ImageAdapter(this, clickEvent)
                //recyclerView.layoutManager = GridLayoutManager(this, 3)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putStringArray(ITEM_KEY, image)
                }
            }
    }
}