package com.natiqhaciyef.travelguideapp.data.repository

import com.natiqhaciyef.travelguideapp.data.model.User
import com.natiqhaciyef.travelguideapp.data.source.AppDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AppUserRepository(val ds: AppDataSource) {

    suspend fun addUser(user: User) = withContext(Dispatchers.IO){
        ds.addUser(user)
    }

    suspend fun getUserByEmail(email: String) = withContext(Dispatchers.IO){
        ds.getUserByEmail(email)
    }

    suspend fun deleteUser(user: User) = withContext(Dispatchers.IO){
        ds.deleteUser(user)
    }

    suspend fun updateUser(user: User) = withContext(Dispatchers.IO){
        ds.updateUser(user)
    }

}