package com.kimi.room

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.kimi.room.data.GameDatabase
import com.kimi.room.data.Record
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Room Test

        val record = Record("Jack", 3)

        Thread {
            GameDatabase.getInstance(this)?.recordDao()?.insert(record)
        }.start()

//        AsyncTask.execute {
//            val list = GameDatabase.getInstance(this)?.recordDao()?.getAll()
//            list?.forEach {
//                Log.d("kimi", "kimi: ${it.nickname}, ${it.id}")
//            }
//        }

        CoroutineScope(Dispatchers.IO).launch {
            val list = GameDatabase.getInstance(this@MainActivity)?.recordDao()?.getAll()
            list?.forEach {
                Log.d("kimi CoroutineScope", "kimi: ${it.nickname}, ${it.id}")
            }

        }

    }
}
