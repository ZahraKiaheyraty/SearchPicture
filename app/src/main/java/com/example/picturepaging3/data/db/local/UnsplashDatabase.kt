package com.example.picturepaging3.data.db.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.picturepaging3.data.db.local.dao.UnsplashImageDao
import com.example.picturepaging3.data.db.local.dao.UnsplashRemoteKeysDao
import com.example.picturepaging3.data.model.UnsplashImage
import com.example.picturepaging3.data.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {
    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}