package com.example.nammashasane.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nammashasane.data.model.InscriptionEntity

@Dao
interface InscriptionDao {

    @Insert
    suspend fun insertInscription(
        inscription: InscriptionEntity
    )

    @Query("SELECT * FROM inscriptions")
    suspend fun getAllInscriptions():
            List<InscriptionEntity>
}