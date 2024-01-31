package com.example.a7minuteworkout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //val flStartButton :FrameLayout = findViewById(R.id.flStart)

        binding?.flStart?.setOnClickListener{
           val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        binding?.flBMI?.setOnClickListener{
            val intent = Intent(this@MainActivity,BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.flHistory?.setOnClickListener{
            val intent = Intent(this@MainActivity,HistoryActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {    //to unassign the binding to avoid memory leak
        super.onDestroy()
        binding = null
    }
}