package com.example.stualgorithm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.stualgorithm.R
import com.example.stualgorithm.algorithm.Sort
import com.example.stualgorithm.utils.InputUtil
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //输入
        val array = InputUtil.getRandomIntArrays()
        val inputTime = System.currentTimeMillis()
        Log.d(TAG, "Input: ${array.contentToString()}")

        //输出
        Sort.MERGE.excute(array)
        val outputTime = System.currentTimeMillis()
        Log.d(TAG, "Output: ${array.contentToString()}")

        Log.d(TAG, "useTime: ${outputTime - inputTime}ms")
    }

}
