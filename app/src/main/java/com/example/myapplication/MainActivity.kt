package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : Activity() {

    var trafficLightImage: ImageView? = null
    var imageArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green, R.drawable.semafor_grey)
    var counter = 0
    var isStart = false

    var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trafficLightImage = findViewById(R.id.trafficLightImage)
    }

    fun onClickStartStop(view: View) {
        view as ImageView
        isStart = !isStart

        if (isStart) {
            view.setImageResource(R.drawable.button_stop)
            timerStartStop()
        } else {
            timer?.cancel()
            view.setImageResource(R.drawable.button_start)
            trafficLightImage?.setImageResource(imageArray[3])
        }

    }

    fun timerStartStop() {
        timer = Timer()
        timer?.schedule(0, 1000) {
            runOnUiThread {
                if (counter == 3) counter = 0
                trafficLightImage?.setImageResource(imageArray[counter])
                counter++
            }
        }
    }


}