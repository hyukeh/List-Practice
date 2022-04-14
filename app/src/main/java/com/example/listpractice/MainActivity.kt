package com.example.listpractice


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listpractice.databinding.ActivityMainBinding
import com.example.listpractice.util.DataGenerator

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter = ChatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter

        binding.buttonRandom.setOnClickListener {
            val data = DataGenerator.get()
            adapter.setData(data)
        }
    }
}