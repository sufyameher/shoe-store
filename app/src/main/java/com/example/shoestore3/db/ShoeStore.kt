package com.example.shoestore3.db

import androidx.room.PrimaryKey

annotation class Entity(val tableName: String)

@Entity(tableName = "shoestoretable")
data class ShoeStoreTable(
    @PrimaryKey(autoGenerate = true)
    val name: String,
    val company: String,
    val size: String,
    val description: String,
)
