package edu.temple.imagedisplayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_1, SelectionFragment.newInstance(generateTestData()))
                .add(R.id.container_2, DisplayFragment())
                .commit()




        // Set the title for the activity.
        supportActionBar?.title = "Selector"

        //val items = generateTestData()
        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.layoutManager = GridLayoutManager(this, 3)

//        val clickEvent = { item: Image ->
//            // Item object can be placed directly inside Intent because
//            // the Item class implements the Parcelable interface
//            val launchIntent = Intent(this, DisplayFragment::class.java)
//                .putExtra(ITEM_KEY, item)
//
//            startActivity(launchIntent)
//        }

        //recyclerView.adapter = ImageAdapter(items, clickEvent)

//            //fragments
//            if (savedInstanceState == null) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.container_1, SelectionFragment.newInstance())
//                    .add(R.id.container_2, DisplayFragment())
//                    .commit()
//            }
        }
    }

    fun generateTestData(): Array<Image> {
        return arrayOf(
            Image(R.drawable.ccf_original, "Original"),
            Image(R.drawable.ccf_freshstrawberry, "Fresh Strawberry"),
            Image(R.drawable.ccf_chocolatecaramelicious, "Chocolate Caramelicious Cheesecake "),
            Image(R.drawable.ccf_pineappleupsidedown, "Pineapple Upside-Down"),
            Image(R.drawable.ccf_celebration, "Celebration"),
            Image(R.drawable.ccf_caramelapple, "Caramel Apple"),
            Image(
                R.drawable.ccf_verycherryghirardellichocolate,
                "Very Cherry Ghirardelli® Chocolate"
            ),
            Image(R.drawable.ccf_lowlicious, "Low-Licious"),
            Image(R.drawable.ccf_cinnaboncinnamoncwirl, "Cinnabon® Cinnamon Swirl"),
            Image(R.drawable.ccf_godiva, "Godiva® Chocolate"),
            Image(R.drawable.ccf_coconutcreampie, "Coconut Cream Pie"),
            Image(R.drawable.ccf_saltedcaramel, "Salted Caramel")
        )
    }


