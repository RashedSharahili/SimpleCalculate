package com.example.simplecalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simplecalculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCalculate.setOnClickListener {

            calculate()
        }
    }

    private fun calculate() {

        val stringNum1 = binding.numberOne.text.toString()
        val num1 = stringNum1.toDouble()

        val stringNum2 = binding.numberTwo.text.toString()
        val num2 = stringNum2.toDouble()

        val selectedOption = binding.rgCalculationsOptions.checkedRadioButtonId

        val stringOpration: String
        val res: Double

        when(selectedOption) {

            binding.rbPlus.id -> {

                res = num1.plus(num2)
                stringOpration = "+"
            }
            binding.rbMinus.id -> {

                res = num1.minus(num2)
                stringOpration = "-"
            }
            else -> {

                res = num1.div(num2)
                stringOpration = "/"
            }
        }

        val result = res

        binding.tvResult.text = getString(R.string.result_txt, num1.toString(), stringOpration, num2.toString(), result.toString())
    }
}