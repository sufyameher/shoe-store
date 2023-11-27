package com.example.shoestore3.shoelist


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoestore3.databinding.RvAddItemBinding
import com.example.shoestore3.db.ShoeStoreTable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddShoeActivity : AppCompatActivity() {

    private lateinit var binding: RvAddItemBinding
    private lateinit var ShoeVM: ShoeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RvAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ShoeVM = ViewModelProvider(this).get(ShoeVM::class.java)

        binding.saveButton.setOnClickListener {
            val name = binding.editTextName.text.toString().trim()
            val company = binding.editTextCompany.text.toString().trim()
            val shoeSize = binding.editTextSize.text.toString().toInt()
            val description = binding.editTextDescription.text.toString().trim()

            if (name.isNotEmpty() && company.isNotEmpty() && description.isNotEmpty()) {
                val shoeStoreTable = ShoeStoreTable(
                    name = name,
                    company = company,
                    shoeSize = shoeSize,
                    description = description)
                ShoeVM.insert(ShoeStoreTable)
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
