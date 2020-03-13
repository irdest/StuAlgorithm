package com.example.stualgorithm.utils

import kotlin.random.Random

//输入类工具
object InputUtil {

    /**
    * ---获取一个随机数组，默认长度10
    * */
    fun getRandomIntArrays() = getRandomIntArrays(10)

    fun getRandomIntArrays(length: Int): IntArray{
        val randomArrays = IntArray(length) {0}

        for (i in 0 until length) {
            randomArrays[i] = Random.nextInt(100);
        }

        return randomArrays
    }

}