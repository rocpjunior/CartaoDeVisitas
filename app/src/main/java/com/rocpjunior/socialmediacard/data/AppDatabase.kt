package com.rocpjunior.socialmediacard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SocialMediaCard::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun socialMediaCardDao(): SocialMediaCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "socialmediacard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
