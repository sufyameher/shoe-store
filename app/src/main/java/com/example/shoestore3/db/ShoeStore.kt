package com.example.shoestore3.db

import androidx.room.Entity
import androidx.room.PrimaryKey

const val SHOE_STORE_ENTITY = "shoe_store_entity"

@Entity(tableName = SHOE_STORE_ENTITY)
data class ShoeStoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id: String = 1,

    val name: String,

    val company: String,

    val size: String,

    val description: String,
)
