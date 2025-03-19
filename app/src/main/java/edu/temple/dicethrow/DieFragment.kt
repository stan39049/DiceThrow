package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    val ROLL = "roll"
    var currentRoll = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    fun multiSide(sides: Int): DieFragment {
        return DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE, sides)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROLL, currentRoll)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState != null){
            currentRoll = savedInstanceState.getInt(ROLL)
            dieTextView.text = currentRoll.toString()
        }else{
            throwDie()
        }
        view.setOnClickListener{
            throwDie()
        }
    }

    fun throwDie() {
        currentRoll = (Random.nextInt(dieSides)+1)
        dieTextView.text = currentRoll.toString()
    }
}