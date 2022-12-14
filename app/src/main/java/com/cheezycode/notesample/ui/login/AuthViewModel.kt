package com.cheezycode.notesample.ui.login

import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.notesample.models.UserRequest
import com.cheezycode.notesample.models.UserResponse
import com.cheezycode.notesample.repository.UserRepository
import com.cheezycode.notesample.utils.Helper
import com.cheezycode.notesample.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userResponseLiveData: LiveData<NetworkResult<UserResponse>>
        get() = userRepository.userResponseLiveData

    fun registerUser(userRequest: UserRequest) {
        viewModelScope.launch {
            userRepository.registerUser(userRequest)
        }
    }

    fun loginUser(userRequest: UserRequest) {
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }

//    fun validateCredentials(emailAddress: String, userName: String, password: String,
//     isLogin: Boolean) : Pair<Boolean, String> {
//
//        var result = Pair(true, "")
//        if(TextUtils.isEmpty(emailAddress) || (!isLogin && TextUtils.isEmpty(userName)) || TextUtils.isEmpty(password)){
//            result = Pair(false, "Please provide the credentials")
//        }
//        else if(!Helper.isValidEmail(emailAddress)){
//            result = Pair(false, "Email is invalid")
//        }
//        else if(!TextUtils.isEmpty(password) && password.length <= 5){
//            result = Pair(false, "Password length should be greater than 5")
//        }
//        return result
//    }

    fun validateCredentials(
        emailAddress: String,
        userName: String,
        password: String,
        isLogin: Boolean
    ): Pair<Boolean, String> {
        var result = Pair(true, "")
        if (! isLogin && TextUtils.isEmpty(userName) || TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(
                password
            )
        ) {
            result = Pair(false, "Please Provcide credentials")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
            result = Pair(false, "Please provide valid email")
        } else if (password.length <= 5 || TextUtils.isEmpty(password)) {
            result = Pair(false, "Please provide valid password or Enter email")
        }
        return result
    }

}