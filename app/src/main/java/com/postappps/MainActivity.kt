package com.postappps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.postappps.adapter.PostAdapter
import com.postappps.databinding.ActivityMainBinding
import com.postappps.utils.ApiState
import com.postappps.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var postAdapter: PostAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        mainViewModel.getPost()
        lifecycleScope.launch {
            mainViewModel._postStateFlow.collect {
                when (it) {
                    is ApiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.recyclerview.visibility = View.GONE
                    }
                    is ApiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerview.visibility = View.VISIBLE
                        postAdapter.setPost(it.data)
                    }
                    is ApiState.Failure -> {
                        binding.progressBar.visibility = View.GONE
                        binding.recyclerview.visibility = View.GONE
                    }
                    is ApiState.Empty -> {

                    }
                }
            }
        }
    }

    private fun initViews() {
        binding.recyclerview.apply {
            postAdapter = PostAdapter(ArrayList())
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = postAdapter
        }
    }
}