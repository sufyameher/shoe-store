package com.example.shoestore3.di

import android.content.Context
import androidx.room.Room
import com.example.shoestore3.db.ShoeStoreDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
     @Provides
     @Singleton
     fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
         return Room.databaseBuilder(
             context,
             AppDatabase::class.java, "app-database"
         ).build()
     }
    @Provides
    fun provideShoestoreDao(appDatabase: AppDatabase): ShoeStoreDAO {
        return appDatabase.shoestoreDao()
    }
}
}