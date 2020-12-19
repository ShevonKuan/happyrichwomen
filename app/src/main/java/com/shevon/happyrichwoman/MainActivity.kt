package com.shevon.happyrichwoman

import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.SeekBar
import android.widget.Switch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var time = 500
        var wait = 500
        val vibrator = this.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator //振动
        val seekbar1 = findViewById<SeekBar>(R.id.time) //持续时间
        val seekbar2 = findViewById<SeekBar>(R.id.waiting) //等待时间seekbar
        seekbar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            // 当拖动条的滑块位置发生改变时触发该方法
            override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean)
            {

                time = progress
            }

            override fun onStartTrackingTouch(bar: SeekBar)
            {
            }

            override fun onStopTrackingTouch(bar: SeekBar)
            {
            }
        })
        seekbar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener
        {
            // 当拖动条的滑块位置发生改变时触发该方法
            override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean)
            {

                wait = progress
            }

            override fun onStartTrackingTouch(bar: SeekBar)
            {
            }

            override fun onStopTrackingTouch(bar: SeekBar)
            {
            }
        })

        val button = findViewById<Switch>(R.id.switch1)
        button.setOnCheckedChangeListener{buttonView, isChecked ->
            if (isChecked){
                // 开关打开的话
                //var pattern: LongArray =
                vibrator.vibrate(longArrayOf(wait.toLong(),time.toLong(),wait.toLong(),time.toLong()),1)
            }else{
                //开关关闭的话
                vibrator.cancel()
            }


        }



    }
}