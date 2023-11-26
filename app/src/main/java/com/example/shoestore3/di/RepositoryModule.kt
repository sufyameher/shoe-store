package com.example.shoestore3.di

import com.example.shoestore3.db.ShoeStoreDAO
import com.example.shoestore3.db.ShoeStoreRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Provides
    fun provideItemRepository(shoeStoreDAO: ShoeStoreDAO): ShoeStoreRepo {
        return ShoeStoreRepo(shoeStoreDAO)
    }
}