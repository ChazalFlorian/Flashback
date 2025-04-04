package com.fchazal.signin.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fchazal.signin.data.database.entity.CredentialEntity

@Dao
interface CredentialsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(credentialEntity: CredentialEntity): Long

    @Query("SELECT * FROM credential WHERE email = :email")
    suspend fun getCredentialsByEmail(email: String): CredentialEntity?

    @Query("UPDATE credential SET token = :newToken WHERE id = :email")
    suspend fun updateToken(email: String, newToken: String)
}