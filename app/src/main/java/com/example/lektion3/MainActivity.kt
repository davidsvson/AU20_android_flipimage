package com.example.lektion3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animalImageView = findViewById<ImageView>(R.id.imageView)

        val flipImage = findViewById<FlipImageView>(R.id.animalFlipView)



        flipImage.onDownImage = R.drawable.dog

        //version 2 använder en imageView och la till en touchlistener på den
        // om vi trycker på bilden visas en katt
        // släpper vi igen visas en hund
        animalImageView.setOnTouchListener { v, event ->
            when(event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    animalImageView.setImageResource(R.drawable.cat)
                }
                MotionEvent.ACTION_UP -> {
                    animalImageView.setImageResource(R.drawable.dog)
                }

            }
            true
        }


    }




/*  //version 1
    // kommer att köras om ett touch event sker någon stans i hela aktiviteten
    override fun onTouchEvent(event: MotionEvent?): Boolean {
       // Log.d("!!!", "Touch!")
        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("!!!", "DOWN!")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("!!!", "UP!")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("!!!", "MOVE!")
            }
        }

        return super.onTouchEvent(event)
    }
*/
}


// reagerade på knapp tryck på 2 sätt
//1. xml-fil - onClick angav vilken funktion som skulle köras

//2. hade en clicklistener på knappen i vår kotlin kod

//view