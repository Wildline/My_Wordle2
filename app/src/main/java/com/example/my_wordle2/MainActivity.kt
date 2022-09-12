package com.example.my_wordle2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.view.View
import android.content.Context
import com.example.my_wordle2.FourLetterWordList.getRandomFourLetterWord
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    var counter = 0
    val wordToGuess = getRandomFourLetterWord()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val guess1 = findViewById<TextView>(R.id.textView3)
        val checkGuess1 = findViewById<TextView>(R.id.textView8)
        val guess2 = findViewById<TextView>(R.id.textView10)
        val checkGuess2 = findViewById<TextView>(R.id.textView12)
        val guess3 = findViewById<TextView>(R.id.textView14)
        val checkGuess3 = findViewById<TextView>(R.id.textView16)
        val correctWord = findViewById<TextView>(R.id.textView4)
        //correctWord.text = wordToGuess
        val simpleEditText = findViewById<EditText>(R.id.editTextTextPersonName)

        button.setOnClickListener {
            counter++
            val strValue = simpleEditText.text.toString().uppercase()
            if(counter == 1 ){
                guess1.text = strValue
                it.hideKeyboard()
                simpleEditText.text.clear()
                val check1 = checkGuess(guess1.text as String)
                checkGuess1.text = check1


            }
            if( counter == 2){
                guess2.text = strValue
                it.hideKeyboard()
                simpleEditText.text.clear()
                val check2 = checkGuess(guess2.text as String)
                checkGuess2.text = check2
            }
            if(counter == 3){
                guess3.text = strValue
                it.hideKeyboard()
                simpleEditText.text.clear()
                val check3 = checkGuess(guess3.text as String)
                checkGuess3.text = check3
                correctWord.text = wordToGuess
            }
            if(counter > 3){
                button.setBackgroundColor(Color.GRAY)
                button.isClickable = false
                //correctWord.text = wordToGuess
                it.hideKeyboard()
                simpleEditText.text.clear()

               /* rightWord.text = wordToGuess */
            }
        }



    }


    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

