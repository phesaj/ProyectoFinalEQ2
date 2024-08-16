package com.jrbco.androidbasic12.Proyecto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jrbco.androidbasic12.R
import com.jrbco.androidbasic12.databinding.ActivityProyectMainBinding

class ProyectMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProyectMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProyectMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, DisplayInfoFragment.newInstance())
            .commit()


    }
}