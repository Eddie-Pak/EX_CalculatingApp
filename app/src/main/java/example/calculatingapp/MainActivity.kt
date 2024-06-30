package example.calculatingapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import example.calculatingapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var number = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberTextView = binding.numberTextView
        val resetButton = binding.resetButton
        val minusButton = binding.minusButton
        val plusButton = binding.plusButton

        resetButton.setOnClickListener {
            number = 0
            numberTextView.text = number.toString()
        }

        plusButton.setOnClickListener {
            number += 1
            numberTextView.text = number.toString()
        }

        minusButton.setOnClickListener {
            number -= 1
            if (number < 0) {
                number = 0
            }
            numberTextView.text = number.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("number", number)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        number = savedInstanceState.getInt("number")
        binding.numberTextView.text = number.toString()
        super.onRestoreInstanceState(savedInstanceState)
    }
}