package com.example.lab12_tarasenko

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab12_tarasenko.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newGame()
    }

    private fun newGame(){
        binding.editText.text.clear()

        val word = getRandomWord()

        val mixed = shuffleWord(word)

        binding.scrambledWord.text = mixed

        binding.button.setOnClickListener {
            val attempt = binding.editText.text.toString() ?:""

            if (attempt == word){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                newGame()
            } else {
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getRandomWord(): String {
        val words = resources.getStringArray(R.array.words)
        return "${words[Random.nextInt(words.size)]}"
    }

    private fun shuffleWord(inputString: String): String {
        val alphabets = inputString.toMutableList()
        return alphabets.shuffled().joinToString("")
    }
}