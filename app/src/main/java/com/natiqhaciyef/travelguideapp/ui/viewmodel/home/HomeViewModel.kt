package com.natiqhaciyef.travelguideapp.ui.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.travelguideapp.data.model.User
import com.natiqhaciyef.travelguideapp.data.repository.AppUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var userRepo: AppUserRepository
) : ViewModel() {
    val userName = MutableLiveData<User>()

    fun getUserName(email: String){
        viewModelScope.launch(Dispatchers.Main) {
            userName.value = userRepo.getUserByEmail(email)
        }
    }

}