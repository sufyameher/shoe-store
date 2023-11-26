package com.example.shoestore3.db

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ShoeStoreRepo @Inject constructor(private val shoeStoreDAO: ShoeStoreDAO) {
   val allShoeStoreTable: LiveData<List<ShoeStoreTable>> = ShoeStoreDAO.getAllShoeStore()

    suspend fun insert(shoeStoreTable: ShoeStoreTable) {
        shoeStoreDAO.insertShoeStore(shoeStoreTable)
    }
}
