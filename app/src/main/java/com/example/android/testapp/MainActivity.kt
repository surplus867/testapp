package com.example.android.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import com.example.android.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var myViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the viewModel
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        binding.viewModel = myViewModel
        binding.lifecycleOwner = this


        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(char: CharSequence?, p1: Int, p2: Int, p3: Int) {
               myViewModel.setMessage(char.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }
}