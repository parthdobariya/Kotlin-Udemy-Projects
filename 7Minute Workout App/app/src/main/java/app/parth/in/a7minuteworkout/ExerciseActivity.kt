package app.parth.`in`.a7minuteworkout

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {

    private var restTimer: CountDownTimer? = null
    private var restProcess = 0

    private var exerciseTimer: CountDownTimer? = null
    private var exerciseProcess = 0
    private var exerciseTimerDuration: Long = 30

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        setSupportActionBar(toolbar_exercise_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_exercise_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()

        llRestView.visibility
    }

    override fun onDestroy() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProcess = 0
        }
        super.onDestroy()

    }

    private fun setRestProgressBar() {
        progressBar.progress = restProcess
        restTimer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                restProcess++
                progressBar.progress = 10 - restProcess
                tvTimer.text = (10 - restProcess).toString()
            }

            override fun onFinish() {
                setupExerciseView()
            }
        }.start()
    }

    private fun setExerciseProgressBar() {
        progressBarExercise.progress = exerciseProcess
        exerciseTimer = object : CountDownTimer(exerciseTimerDuration * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                exerciseProcess++
                progressBarExercise.progress = exerciseTimerDuration.toInt() - exerciseProcess
                tvExerciseTimer.text = (exerciseTimerDuration.toInt() - exerciseProcess).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Hear we will start the nest rest screen.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.start()
    }

    private fun setupExerciseView() {
        llRestView.visibility = View.GONE
        llExerciseView.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer!!.cancel()
            exerciseProcess = 0
        }
        setExerciseProgressBar()
    }

    private fun setupRestView() {
        if (restTimer != null) {
            restTimer!!.cancel()
            restProcess = 0
        }
        setRestProgressBar()
    }

}