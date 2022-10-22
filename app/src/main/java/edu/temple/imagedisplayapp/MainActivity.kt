package edu.temple.imagedisplayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

            companion object
            {
                val ITEM_KEY = "key"
            }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_1, SelectionFragment.newInstance(generateTestData()))
                .add(R.id.container_2, DisplayFragment())
                .commit()

        // Set the title for the activity.
        supportActionBar?.title = "Selector"
    }

}

    fun generateTestData(): Array<Image>
    {
        return arrayOf(
            Image(R.drawable.ccf_original, "Original"),
            Image(R.drawable.ccf_freshstrawberry, "Fresh Strawberry"),
            Image(R.drawable.ccf_chocolatecaramelicious, "Chocolate Caramelicious Cheesecake "),
            Image(R.drawable.ccf_pineappleupsidedown, "Pineapple Upside-Down"),
            Image(R.drawable.ccf_celebration, "Celebration"),
            Image(R.drawable.ccf_caramelapple, "Caramel Apple"),
            Image(R.drawable.ccf_verycherryghirardellichocolate, "Very Cherry Ghirardelli® Chocolate"),
            Image(R.drawable.ccf_lowlicious, "Low-Licious"),
            Image(R.drawable.ccf_cinnaboncinnamoncwirl, "Cinnabon® Cinnamon Swirl"),
            Image(R.drawable.ccf_godiva, "Godiva® Chocolate"),
            Image(R.drawable.ccf_coconutcreampie, "Coconut Cream Pie"),
            Image(R.drawable.ccf_saltedcaramel, "Salted Caramel"))
    }


