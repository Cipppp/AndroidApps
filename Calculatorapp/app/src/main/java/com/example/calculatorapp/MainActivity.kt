package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Numbers
        calOne.setOnClickListener { appendOnExpression("1", true)}
        calTwo.setOnClickListener { appendOnExpression("2", true)}
        calThree.setOnClickListener { appendOnExpression("3", true)}
        calFour.setOnClickListener { appendOnExpression("4", true)}
        calFive.setOnClickListener { appendOnExpression("5", true)}
        calSix.setOnClickListener { appendOnExpression("6", true)}
        calSeven.setOnClickListener { appendOnExpression("7", true)}
        calEight.setOnClickListener { appendOnExpression("8", true)}
        calNine.setOnClickListener { appendOnExpression("9", true)}
        calZero.setOnClickListener { appendOnExpression("0", true)}
        calDot.setOnClickListener { appendOnExpression(".", true)}

        // Operators
        calPlus.setOnClickListener { appendOnExpression("+", false)}
        calMinus.setOnClickListener { appendOnExpression("-", false)}
        calMul.setOnClickListener { appendOnExpression("*", false)}
        calDivide.setOnClickListener { appendOnExpression("/", false)}
        calOpen.setOnClickListener { appendOnExpression("(", false)}
        calClose.setOnClickListener { appendOnExpression(")", false)}

        calClear.setOnClickListener {
            calcExpression.text = ""
            calcResult.text = ""
        }

        calBack.setOnClickListener{
            val string = calcExpression.text.toString()
            if (string.isNotEmpty()) {
                calcExpression.text = string.substring(0, string.length - 1)
            }
             calcResult.text = ""
        }

        calEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(calcExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    calcResult.text = longResult.toString()
                else
                    calcResult.text = result.toString()
            } catch (e:Exception) {
                Log.d("Exception", "message : " + e.message)
            }
        }

    }

    fun appendOnExpression( string: String, canClear: Boolean) {
        if (calcResult.text.isNotEmpty()) {
            calcExpression.text = ""
        }
        if (canClear) {
            calcResult.text = ""
            calcExpression.append(string)
        } else {
            calcExpression.append(calcResult.text)
            calcExpression.append(string)
            calcResult.text = ""
        }
    }
}