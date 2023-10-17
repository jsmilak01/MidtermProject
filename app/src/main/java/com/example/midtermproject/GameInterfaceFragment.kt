package com.example.midtermproject

import GameViewModel
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameInterfaceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameInterfaceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mediaPlayer = MediaPlayer.create(this.context, R.raw.buzz)
        val view = inflater.inflate(R.layout.fragment_game_interface, container, false)
        val minusButton = view.findViewById<Button>(R.id.minus_button)
        val addButton = view.findViewById<Button>(R.id.add_button)
        val playerGuessBox = view.findViewById<EditText>(R.id.player_guess)
        val playerName = view.findViewById<EditText>(R.id.player_name)
        val okButton = view.findViewById<Button>(R.id.ok_button)

        val numToGuess = Random.nextInt(1,100)
        val higherToastText = "Your guess was higher than the number."
        val lowerToastText = "Your guess was lower than the number."
        val toastDuration = Toast.LENGTH_SHORT

        val higherToast = Toast.makeText(this.context, higherToastText, toastDuration)
        val lowerToast = Toast.makeText(this.context, lowerToastText, toastDuration)
        var guesses = 0

        minusButton.setOnClickListener {
            var curGuessStr = playerGuessBox.text.toString()
            if(curGuessStr != ""){
                var curGuessInt = curGuessStr.toInt()
                curGuessInt -= 1
                playerGuessBox.setText("$curGuessInt")
            }
        }

        addButton.setOnClickListener {
            var curGuessStr = playerGuessBox.text.toString()
            if(curGuessStr != ""){
                var curGuessInt = curGuessStr.toInt()
                curGuessInt += 1
                playerGuessBox.setText("$curGuessInt")
            }
        }

        okButton.setOnClickListener {
            val name = playerName.text.toString()
            if(playerGuessBox.text.toString() == ""){
                //increment number of guesses in bottom and play wrong answer
                guesses++
            }else{
                val curGuess = playerGuessBox.text.toString().toInt()
                if(curGuess == numToGuess){
                    //store name and attempts to database and back to start
                    //change start screen text to "$playername score: $score \n Play Another Game?"
                    this.parentFragmentManager.commit{
                        val userName = playerName.text.toString()
                        val score = guesses+1
                        replace(R.id.fragment_container, MainFragment.newInstance("$userName score: $score"))
                    }
                }else if(curGuess < numToGuess){
                    mediaPlayer.start()
                    lowerToast.show()
                    guesses++
                    viewModel.setNumAttempts("Number of attempts: $guesses")
                    //increment guesses and stay on the screen
                }else if(curGuess > numToGuess){
                    mediaPlayer.start()
                    higherToast.show()
                    guesses++
                    viewModel.setNumAttempts("Number of attempts: $guesses")
                    //increment guesses and stay on screen
                }
            }

        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameInterfaceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameInterfaceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}