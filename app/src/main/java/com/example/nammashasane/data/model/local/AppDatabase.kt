package com.example.nammashasane.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nammashasane.data.model.InscriptionEntity

@Database(
    entities = [InscriptionEntity::class],
    version = 1
)

abstract class AppDatabase :
    RoomDatabase() {

    abstract fun inscriptionDao():
            InscriptionDao
}