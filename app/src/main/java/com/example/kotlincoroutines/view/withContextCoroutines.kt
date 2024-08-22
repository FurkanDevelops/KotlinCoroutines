package com.example.kotlincoroutines.view

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    //WİTH CONTEXT
    runBlocking {
        launch(Dispatchers.Default) {
            println(coroutineContext)
            withContext(Dispatchers.IO){
                println(coroutineContext)
            }
        }
    }
}