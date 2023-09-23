package com.app.sampleitkone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.sampleitkone.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private var paramEmail: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadData()
    }

    private fun loadData() {
        paramEmail = intent.getStringExtra(EXTRA_EMAIL)
        binding.tvEmail.text = paramEmail
    }

    companion object {
        private const val EXTRA_EMAIL = "extra_email"

        fun start(context: Context, email: String) {
            val starter = Intent(context, ProfileActivity::class.java)
            starter.putExtra(EXTRA_EMAIL, email)
            context.startActivity(starter)
        }
    }
}