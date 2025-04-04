package com.fchazal.signin.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credential")
data class CredentialEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val email: String,
    val token: String,
)
