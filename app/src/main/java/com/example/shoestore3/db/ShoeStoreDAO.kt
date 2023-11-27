package com.example.shoestore3.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShoeStoreDAO {

    @Insert
    suspend fun insertShoeStore(shoeStoreEntity: ShoeStoreEntity)

    @Delete
    suspend fun deleteShoeStore(shoeStoreEntity: ShoeStoreEntity)

    @Update
    suspend fun updateShoeStore(shoeStoreEntity: ShoeStoreEntity)

    @Query("SELECT * FROM $SHOE_STORE_ENTITY")    //to get data from db
    fun getAllShoeStore(): LiveData<List<ShoeStoreEntity>>
}