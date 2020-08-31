package com.ase21.somenetworkingoncoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.shopRateDTOs.observe(this, { t ->
            val comments = t
            textField.text = "count " + comments.count()
        })
        viewModel.getRates()
    }

}