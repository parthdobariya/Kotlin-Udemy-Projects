package app.parth.`in`.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastNumeric: Boolean = false
    var lastDote: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        //Toast.makeText(this, "Button Worked", Toast.LENGTH_SHORT).show()
        tvInput.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View) {
        tvInput.text = ""
        lastDote = false
        lastNumeric = false

    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDote) {
            tvInput.append(".")
            lastNumeric = false
            lastDote = true
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())

                } else if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())

                } else if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())

                } else if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()) {
                        one = prefix + one
                    }

                    tvInput.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                }

            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if (result.contains(".0"))
            value = result.substring(0, result.length - 2)
        return value

    }

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDote = false
        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") ||
                    value.contains("+") || value.contains("-")
        }
    }

}
