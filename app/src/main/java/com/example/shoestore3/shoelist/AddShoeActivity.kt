package com.example.shoestore3.shoelist


import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.shoestore3.databinding.RvAddItemBinding
import com.example.shoestore3.db.ShoeStoreEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddShoeActivity : AppCompatActivity() {

    private lateinit var binding: RvAddItemBinding
    private val shoeViewModel: ShoeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RvAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val company = binding.editTextCompany.text.toString().trim()
            val shoeSize = binding.editTextSize.text.toString().toString()
            val description = binding.editTextDescription.text.toString().trim()

            if (name.isNotEmpty() && company.isNotEmpty() && description.isNotEmpty()) {
                val shoeStoreTable = ShoeStoreEntity(
                    name = name,
                    company = company,
                    size = shoeSize,
                    description = description)
                shoeViewModel.insert(shoeStoreTable)
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
