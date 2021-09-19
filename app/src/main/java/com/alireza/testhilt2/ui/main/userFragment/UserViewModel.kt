package com.alireza.testhilt2.ui.main.userFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.repository.MainRepository
import com.alireza.testhilt2.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val mainRepository: MainRepository , private val savedStateHandle: SavedStateHandle) : ViewModel() {


    private val _dataState:MutableLiveData<DataState<User>> = MutableLiveData()
    val dataState:MutableLiveData<DataState<User>>
        get() = _dataState


    fun setData(event: UserStateEvent<Int>){
        viewModelScope.launch {
            when(event){
                is UserStateEvent.GetUsers ->{
                    mainRepository.getSingleUser(id = event.id).collect {
                        _dataState.value=it
                    }
                }
            }
        }
    }



}