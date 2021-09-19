package com.alireza.testhilt2.ui.main.mainFragment

import androidx.lifecycle.*
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.repository.MainRepository
import com.alireza.testhilt2.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _dataState:MutableLiveData<DataState<List<User>>> = MutableLiveData()
    val dataState : LiveData<DataState<List<User>>>
        get() = _dataState

    fun setState(mainStateEvent: MainStateEvent){
        viewModelScope.launch {
            when (mainStateEvent){
                is MainStateEvent.GetUsersEvent ->{
                    mainRepository.getUsers().collect {
                        _dataState.value=it
                    }
                }
            }
        }
    }


}