package com.rocpjunior.socialmediacard.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.rocpjunior.socialmediacard.App
import com.rocpjunior.socialmediacard.databinding.ActivityMainBinding
import com.rocpjunior.socialmediacard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { SocialMediaCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getAllSocialMediaCard()
        binding.rvCards.adapter = adapter
        insertListener()
    }

    private fun insertListener() {
        binding.floatingActionBtn.setOnClickListener{
            val intent = Intent(this@MainActivity, AddSocialMediaCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }

    }

    private fun getAllSocialMediaCard() {
        mainViewModel.getAll().observe(this, { socialMediaCards ->
            adapter.submitList(socialMediaCards)
        })
    }
}