package com.example.shoestore3.db

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ShoeStoreRepository @Inject constructor(private val shoeStoreDAO: ShoeStoreDAO) {

    val allShoeStoreTable: LiveData<List<ShoeStoreEntity>> = shoeStoreDAO.getAllShoeStore()

    suspend fun insert(shoeStoreTable: ShoeStoreEntity) {
        shoeStoreDAO.insertShoeStore(shoeStoreTable)
    }

}
