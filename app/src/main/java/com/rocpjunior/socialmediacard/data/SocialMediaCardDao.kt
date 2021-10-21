package com.rocpjunior.socialmediacard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SocialMediaCardDao {

    @Query("SELECT * FROM SocialMediaCard")
    fun getAll(): LiveData<List<SocialMediaCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(socialMediaCard: SocialMediaCard)
}