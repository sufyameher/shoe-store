package com.example.shoestore3.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shoestore3.databinding.ActivityLoginBinding
import com.example.shoestore3.shoelist.ListActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener{
            navigateToListActivity()
        }
    }

    fun navigateToListActivity() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        if (isValidCredentials(email, password)) {
            showToast("Login successful")
            val listActivity = Intent(this, ListActivity::class.java)
            startActivity(listActivity)
        } else {
            showToast("Invalid credentials. Please try again.")
        }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}