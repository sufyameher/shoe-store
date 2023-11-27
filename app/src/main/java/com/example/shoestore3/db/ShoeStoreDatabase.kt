package com.example.shoestore3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShoeStoreEntity::class], version = 1)
abstract class ShoeStoreDatabase: RoomDatabase(){
    abstract fun shoestoreDao() : ShoeStoreDAO

    companion object {
        @Volatile
        private var INSTANCE: ShoeStoreDatabase? = null

        fun getDatabase(context: Context): ShoeStoreDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoeStoreDatabase::class.java,
                    "shoe_store_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

