package com.rocpjunior.socialmediacard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

class SocialMediaCardRepository(private val dao: SocialMediaCardDao) {

    fun insert(socialMediaCard: SocialMediaCard) = runBlocking{
        launch(Dispatchers.IO) {
            dao.insert(socialMediaCard)
        }
    }

    fun getAll() = dao.getAll()
}