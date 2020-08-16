package app.parth.`in`.a7minuteworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(toolbar_exercise_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}