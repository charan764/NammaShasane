package com.example.nammashasane.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inscriptions")

data class InscriptionEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val location: String,

    val translation: String,

    val dynasty: String,

    val latitude: Double,

    val longitude: Double,

    val history: String = "",

    val imageUrl: String = ""
)