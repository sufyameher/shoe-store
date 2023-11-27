package com.example.shoestore3.di

import android.content.Context
import androidx.room.Room
import com.example.shoestore3.db.ShoeStoreDAO
import com.example.shoestore3.db.ShoeStoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
     @Provides
     @Singleton
     fun provideAppDatabase(@ApplicationContext context: Context): ShoeStoreDatabase {
         return Room.databaseBuilder(
             context,
             ShoeStoreDatabase::class.java, "app-database"
         ).build()
     }
    @Provides
    fun provideShoestoreDao(appDatabase: ShoeStoreDatabase): ShoeStoreDAO {
        return appDatabase.shoestoreDao()
    }
}
