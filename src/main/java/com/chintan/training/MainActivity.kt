package com.chintan.training

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mBListExample: Button
    private lateinit var mBBank: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBListExample = findViewById(R.id.mBListExample)
        mBBank = findViewById(R.id.button)

        mBListExample.setOnClickListener {
            startActivity(Intent(this, ListRecycleView::class.java))
        }

        //  amt*Math.pow((1+((rate/100)/freq)), freq*year);
//        val months = year * 12
//        var maturity = 0
//        for (i in 1..months) {
//            maturity += amt * Math.pow(1 + rate / 100 / freq, freq * ((months - i + 1) / 12))
//        }
//        document.getElementById("maturity").innerText = maturity



        mBBank.setOnClickListener {
            startActivity(Intent(this,BankActivity::class.java))
        }
    }
}