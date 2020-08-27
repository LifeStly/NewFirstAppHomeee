package com.example.newfirstapphomeee.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ContactDatabase : RoomDatabase(){
    abstract val databaseDao: ContactDataDAO

    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null
        fun getInstance(context: Context): ContactDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}