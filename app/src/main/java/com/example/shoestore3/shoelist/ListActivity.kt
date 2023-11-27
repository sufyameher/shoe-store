package com.example.shoestore3.shoelist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoestore3.databinding.RvListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var binding: RvListBinding
    private lateinit var shoeVM: ShoeVM
    private lateinit var shoeAdapter: ShoeAdapter
    //private lateinit var dataList:ArrayList<shoemodel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RvListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shoeAdapter = ShoeAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = shoeAdapter


//        val recyclerView = binding.recyclerView
//        val adapter = ShoeAdapter()

        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = adapter

        shoeVM = ViewModelProvider(this).get(ShoeVM::class.java)
        shoeVM.allShoeStoreTable.observe(this, Observer { shoestoretable ->
            shoestoretable?.let { shoeAdapter.setItems(it) }
        })

        binding.addButton.setOnClickListener {
            val intent = Intent(this, AddShoeActivity::class.java)
            startActivity(intent)
        }

    }
}

