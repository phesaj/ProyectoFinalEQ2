package com.jrbco.androidbasic12.Proyecto

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jrbco.androidbasic12.R
import com.jrbco.androidbasic12.databinding.ActivityDataUserBinding
import com.jrbco.androidbasic12.databinding.ActivityProyectMainBinding

class DataUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataUserBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val user = intent.getStringExtra("USER_KEY")
        val password = intent.getStringExtra("PASSWORD_KEY")


        val name = intent.getStringExtra("NAME_KEY")
        val surname = intent.getStringExtra("SURNAME_KEY")
        val email = intent.getStringExtra("EMAIL_KEY")

        if (!name.isNullOrEmpty()) {
            binding.tvName.text = name.toString()
            binding.tvName.visibility = View.VISIBLE
        }else{binding.tvName.visibility = View.GONE}

        if (!surname.isNullOrEmpty()) {
            binding.tvSurname.text = surname.toString()
            binding.tvSurname.visibility = View.VISIBLE
        }else{binding.tvSurname.visibility = View.GONE}

        if (!user.isNullOrEmpty()) {
            binding.tvUser.text = user.toString()
            binding.tvUser.visibility = View.VISIBLE
        }else{binding.tvUser.visibility = View.GONE}

        if (!email.isNullOrEmpty()) {
            binding.tvEmail.text = email.toString()
            binding.tvEmail.visibility = View.VISIBLE
        }else{binding.tvEmail.visibility = View.GONE}

        if (!password.isNullOrEmpty()) {
            binding.tvPassword.text = password.toString()
            binding.tvPassword.visibility = View.VISIBLE
        }else{binding.tvPassword.visibility = View.GONE}


    }
}