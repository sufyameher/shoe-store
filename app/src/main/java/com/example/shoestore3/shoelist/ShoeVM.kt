package com.example.shoestore3.shoelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shoestore3.db.ShoeStoreDB
import com.example.shoestore3.db.ShoeStoreRepo
import com.example.shoestore3.db.ShoeStoreTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

open class ShoeVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val repository: ShoeStoreRepo
    val allShoeStoreTable: LiveData<List<ShoeStoreTable>>

    init {
        val ShoeStoreDAO = ShoeStoreDB.getDatabase(application).shoestoreDao()
        repository = ShoeStoreRepo(ShoeStoreDAO)
        allShoeStoreTable = repository.allShoeStoreTable
    }

    fun insert(shoeStoreTable: ShoeStoreTable) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(shoeStoreTable)
        }
    }
}
