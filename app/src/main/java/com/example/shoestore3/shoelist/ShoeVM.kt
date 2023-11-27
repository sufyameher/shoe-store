package com.example.shoestore3.shoelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shoestore3.db.ShoeStoreDatabase
import com.example.shoestore3.db.ShoeStoreRepository
import com.example.shoestore3.db.ShoeStoreEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class ShoeVM @Inject constructor(application: Application, shoeStoreRepository: ShoeStoreRepository) : AndroidViewModel(application) {

    private val repository: ShoeStoreRepository
    val allShoeStoreTable: LiveData<List<ShoeStoreEntity>>
    init {
        val shoeStoreDao = ShoeStoreDatabase.getDatabase(application).shoestoreDao()
        repository = ShoeStoreRepository(shoeStoreDao)
        allShoeStoreTable = repository.allShoeStoreTable
    }

    fun insert(shoeStoreTable: ShoeStoreEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(shoeStoreTable)
        }
    }
}
