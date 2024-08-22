package com.example.kotlincoroutines.view

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //JOB
    runBlocking {
        val myJob = launch {
            delay(2000)
            println("job")
            val secondJob = launch {
                delay(3000)
                println("second job ")
            }
        }
        myJob.invokeOnCompletion {
            //myJob bitince ne olacağını yaz
            println("my job end")

        }
        myJob.cancel()//iptal etmek için kullanılır

    }
}