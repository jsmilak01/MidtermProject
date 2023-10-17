package com.example.midtermproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PREV_GAME = ""


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var prevGame: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            prevGame = it.getString(ARG_PREV_GAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        if(prevGame != null){
            view.findViewById<TextView>(R.id.home_screen_text).text = "$prevGame \n Play Another Game?"
        }

        val playGameButton = view.findViewById<Button>(R.id.play_game_button)
        val highScoreButton = view.findViewById<Button>(R.id.view_high_scores_button)

        playGameButton.setOnClickListener {
            //start the game and change the screen to game fragment
            this.parentFragmentManager.commit{
                replace(R.id.fragment_container, GameFragment.newInstance("",""))
            }
        }



        highScoreButton.setOnClickListener {
            //go to high score screen
            this.parentFragmentManager.commit{
                //make parameter a list of the high scores
                replace(R.id.fragment_container, HighScoreFragment.newInstance("",""))
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
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(prevGame: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PREV_GAME, prevGame)
                }
            }
    }
}