package com.example.shoestore3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoeStoreTable::class], version = 1)
abstract class ShoeStoreDB: RoomDatabase(){
    abstract fun shoestoreDao() : ShoeStoreDAO

    companion object {
        @Volatile
        private var INSTANCE: ShoeStoreDB? = null

        fun getDatabase(context: Context): ShoeStoreDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoeStoreDB::class.java,
                    "shoestoretable_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

