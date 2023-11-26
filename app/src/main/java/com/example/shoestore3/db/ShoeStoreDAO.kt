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
    suspend fun insertShoeStore(shoeStoreTable: ShoeStoreTable)

    @Delete
    suspend fun deleteShoeStore(shoeStoreTable: ShoeStoreTable)

    @Update
    suspend fun updateShoeStore(shoeStoreTable: ShoeStoreTable)

    @Query("SELECT * FROM shoestoretable")    //to get data from db
    fun getAllShoeStore(): LiveData<List<ShoeStoreTable>>
}