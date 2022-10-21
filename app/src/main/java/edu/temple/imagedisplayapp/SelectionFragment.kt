package edu.temple.imagedisplayapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.temple.imagedisplayapp.MainActivity.Companion.ITEM_KEY

class SelectionFragment : Fragment() {

    lateinit var recyclerView : RecyclerView
    lateinit var image: Array<Image>
    private lateinit var imageViewModel: ImageViewModel
    private val ITEM_KEY = "items"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        imageViewModel = ViewModelProvider(requireActivity()).get(ImageViewModel::class.java)

        arguments?.let {
            //image = it.getParcelableArray(ITEM_KEY) as Array<Image>
            image = it.getSerializable(ITEM_KEY) as Array<Image>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false).also {
            recyclerView = it.findViewById(R.id.recyclerView)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

                val clickEvent = { image: Image ->
                    imageViewModel.setSelectedImage(image)

                }
                recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
                recyclerView.adapter = ImageAdapter(image, clickEvent)

            }

    companion object {
        @JvmStatic
        fun newInstance(items : Array<Image>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ITEM_KEY, items)
                }
            }
    }
    }
