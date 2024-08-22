package com.example.kotlincoroutines.view

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    var userName = ""
    var userAge = 0
    runBlocking {
        val downloadedName = async {
            downloadName()
        }
        val downloadedAge = async {
            downloadAge()
        }
        userName = downloadedName.await()
        userAge = downloadedAge.await()
        // işlemin olmasını bekleyip atama yapar
        // await bu işe yarar
        println(userName)
        println(userAge)

    }
}

suspend fun downloadName(): String{
    delay(2000)
    val userName = "Furkan"
    println("username download")
    return userName
}

suspend fun downloadAge(): Int{
   delay(4000)
   val age = 22
   println("age download")
   return age
}