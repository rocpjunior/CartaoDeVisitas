package com.rocpjunior.socialmediacard

import android.app.Application
import com.rocpjunior.socialmediacard.data.AppDatabase
import com.rocpjunior.socialmediacard.data.SocialMediaCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this)}
    val repository by lazy { SocialMediaCardRepository(database.socialMediaCardDao()) }
}