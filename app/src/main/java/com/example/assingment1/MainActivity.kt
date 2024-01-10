package com.example.assingment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assingment1.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }


    private fun calculateTip() {
        val selectedId = binding.tipOptions.checkedRadioButtonId

        val cost = binding.costOfServices.text.toString().toDouble()
        val selectedID = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_fifteen_percent -> 0.15
            else -> 0.1

        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundTip.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }

        val locale = Locale("si", "LK")
        val CurrencyTip = NumberFormat.getCurrencyInstance(locale).format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, CurrencyTip)


    }
}