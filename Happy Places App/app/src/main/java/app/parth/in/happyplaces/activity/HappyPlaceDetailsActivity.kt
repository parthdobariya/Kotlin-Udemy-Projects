package app.parth.`in`.happyplaces.activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.parth.`in`.happyplaces.R
import app.parth.`in`.happyplaces.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_happy_place_details.*

class HappyPlaceDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_details)

        var happyPlaceDetailsModel: HappyPlaceModel? = null
        if (intent.hasExtra(MainActivity.EXTRA_PLACE_DETAILS)) {
            happyPlaceDetailsModel =
                intent.getParcelableExtra(MainActivity.EXTRA_PLACE_DETAILS) as HappyPlaceModel
        }
        if (happyPlaceDetailsModel != null) {
            setSupportActionBar(toolbar_happy_place_detail)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = happyPlaceDetailsModel.title

            toolbar_happy_place_detail.setNavigationOnClickListener {
                onBackPressed()
            }
            iv_place_image.setImageURI(Uri.parse(happyPlaceDetailsModel.image))
            tv_description.text = happyPlaceDetailsModel.description
            tv_location.text = happyPlaceDetailsModel.location
        }
    }
}