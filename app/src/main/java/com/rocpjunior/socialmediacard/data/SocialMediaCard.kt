package com.rocpjunior.socialmediacard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SocialMediaCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val facebook: String,
    val instagram: String,
    val twitter: String,
    val linkedin: String,
    val fundoPersonalizado: String
)