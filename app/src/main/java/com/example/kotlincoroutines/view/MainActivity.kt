package com.example.kotlincoroutines.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlincoroutines.R
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Light Weightness diye geçer
        // Oldukça verimlidir
        /*
        GlobalScope.launch {
            repeat(1000000){
                //100bin defa tekrar et demek uygulamada çökme olmaz
                println("android")
            }
        }

         */
        //Scope - Kapsam
        // Global Scope = Bütün app içinde kullanılabilir
        // runBlocking = Bloklayarak scope olusturur tek işlem varsa yapılır
        // CoroutineScope = En çok kullanılandır
        /* run blocking
        println("run blocking start")
        runBlocking {
            launch {
                delay(2000)
                println("run blocking")
            }
        }

         */
        /*
        //Context hangi verilerle çalışacağımızı belirler
        CoroutineScope(Dispatchers.Default).launch {
            println("coroutine scope")
        }

         */
        //Dispatchers
        // Dispatchers.Default -> CPU Intensive
        // Dispatchers.IO -> Input / Output, Networking(İnternetten veri cekerken)
        // Dispatchers.Main -> Kullanıcının göreceği
        // Dispatchers.Unconfined -> Inherited dispatcher
        runBlocking {
            launch(Dispatchers.Main){
                println("Main Thread: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Default) {
                println("Default Thread: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined) {
                println("Unconfined Thread ${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO) {
                println("IO Thread ${Thread.currentThread().name}")
            }
        }
    }
}