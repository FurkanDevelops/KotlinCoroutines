package com.example.kotlincoroutines.view

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    //Suspend Fonksiyonlar içinde Coroutine çalıştırılabilen fonksiyonlardır
    //istediğimiz zaman durdurup devam edebiliyoruz
    runBlocking {
        delay(2000)
        println("run blocking")
        myFunction()
    }
}

suspend fun myFunction(){
    coroutineScope {
        delay(4000)
        println("suspend function")
    }
}