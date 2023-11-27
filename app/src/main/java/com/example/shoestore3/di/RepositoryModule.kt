package com.example.shoestore3.di

import com.example.shoestore3.db.ShoeStoreDAO
import com.example.shoestore3.db.ShoeStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideItemRepository(shoeStoreDAO: ShoeStoreDAO): ShoeStoreRepository {
        return ShoeStoreRepository(shoeStoreDAO)
    }
}