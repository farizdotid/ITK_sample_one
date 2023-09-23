package com.app.sampleitkone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.sampleitkone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initAction()
    }

    /**
     * Didalam fungsi ini untuk kodingan yang berususan dengan onClick()
     */
    private fun initAction() {
        binding.btnMasuk.setOnClickListener {
            if (getEmail().isEmpty()){
                showMessage("Email tidak boleh kosong")
            } else if (getPassword().isEmpty()){
                showMessage("Password tidak boleh kosong")
            } else {
               ProfileActivity.start(this, getEmail())
            }
        }
    }

    /**
     * Fungsi untuk mendapatkan nilai dari form Email
     */
    private fun getEmail(): String {
        return binding.etEmail.text.toString()
    }

    /**
     * Fungsi untuk mendapatkan nilai dari form Password
     */
    private fun getPassword(): String {
        return binding.etPassword.text.toString()
    }

    /**
     * Fungsi untuk menampilkan alert/toast dialog simple
     */
    private fun showMessage(message: String = "Form tidak boleh kosong") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}