package com.example.midtermproject

import GameViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_ATTEMPTS = 0
/**
 * A simple [Fragment] subclass.
 * Use the [NumAttemptsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NumAttemptsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var attempts: Int? = null

    private val viewModel: GameViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            attempts = it.getInt(ARG_ATTEMPTS.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_num_attempts, container, false)

        val numAttemptsText = view.findViewById<TextView>(R.id.num_attempts_text)
        //when ok button is clicked run line below to update text
        //numAttemptsText.text = viewModel.getNumAttempts

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NumAttemptsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(attempts: Int) =
            NumAttemptsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ATTEMPTS.toString(), attempts)
                }
            }
    }
}