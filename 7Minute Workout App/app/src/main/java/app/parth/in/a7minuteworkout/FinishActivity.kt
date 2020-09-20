package app.parth.`in`.a7minuteworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(toolbar_finish_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_finish_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        btnFinish.setOnClickListener {
            finish()
        }
    }
}