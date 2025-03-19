package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            val die = DieFragment().multiSide(20)
            val die2 = DieFragment().multiSide(20)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, die).replace(R.id.fragmentContainerView2, die2).commit()
        }
    }
}