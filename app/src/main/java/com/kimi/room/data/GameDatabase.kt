package com.kimi.room.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Kimi.Peng on 2019-11-14.
 */

@Database(entities = arrayOf(Record::class, Word::class), version = 1)
abstract class GameDatabase: RoomDatabase() {

    abstract fun recordDao(): RecordDao

}