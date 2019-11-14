package com.kimi.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.kimi.room.data.GameDatabase
import com.kimi.room.data.Record

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Room Test

        val database = Room.databaseBuilder(this, GameDatabase::class.java, "game.db").build()

        val record = Record("Jack", 3)

        Thread {
            database.recordDao().insert(record)
            Log.d("kimi", "kimi: ${database.recordDao().getAll().size}")
        }.start()

    }
}
