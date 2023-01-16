package com.natiqhaciyef.travelguideapp.ui.viewmodel.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.travelguideapp.data.model.User
import com.natiqhaciyef.travelguideapp.data.repository.AppUserRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    val userRepo: AppUserRepository
): ViewModel() {

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.Main) {
            userRepo.addUser(user)
        }
    }

}