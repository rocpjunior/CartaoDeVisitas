package com.rocpjunior.socialmediacard.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.rocpjunior.socialmediacard.App
import com.rocpjunior.socialmediacard.R
import com.rocpjunior.socialmediacard.data.SocialMediaCard
import com.rocpjunior.socialmediacard.databinding.ActivityAddSocialMediaCardBinding

class AddSocialMediaCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddSocialMediaCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirmation.setOnClickListener {
            val socialMediaCard = SocialMediaCard(
                nome = binding.tilNome.editText?.text.toString(),
                facebook = binding.tilFacebook.editText?.text.toString(),
                instagram = binding.tilInstagram.editText?.text.toString(),
                twitter = binding.tilTwitter.editText?.text.toString(),
                linkedin = binding.tilLinkedin.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(socialMediaCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
            }
        }
    }