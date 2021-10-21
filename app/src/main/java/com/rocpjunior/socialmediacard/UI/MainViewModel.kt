package com.rocpjunior.socialmediacard.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rocpjunior.socialmediacard.data.SocialMediaCard
import com.rocpjunior.socialmediacard.data.SocialMediaCardRepository

class MainViewModel(private val socialMediaCardRepository: SocialMediaCardRepository): ViewModel() {

    fun insert(socialMediaCard: SocialMediaCard) {
        socialMediaCardRepository.insert(socialMediaCard)
    }

    fun getAll(): LiveData<List<SocialMediaCard>> {
        return socialMediaCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: SocialMediaCardRepository) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}