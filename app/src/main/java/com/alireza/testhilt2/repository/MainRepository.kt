package com.alireza.testhilt2.repository

import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.retrofit.NetworkMapper
import com.alireza.testhilt2.retrofit.UserRetrofit
import com.alireza.testhilt2.room.CacheMapper
import com.alireza.testhilt2.room.Dao
import com.alireza.testhilt2.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository constructor(
    private val dao: Dao,
    private val userRetrofit: UserRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getUsers():Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val users:List<User> = networkMapper.getListFromEntities(userRetrofit.getUsers())
            for (user in users){
                dao.insert(cacheMapper.mapToEntity(user))
            }
            emit(DataState.Success(cacheMapper.getListFromEntities(dao.getUsers())))

        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }


    suspend fun getSingleUser(id:Int):Flow<DataState<User>> = flow {
        emit(DataState.Loading)
        delay(500)
        try {

            emit(DataState.Success(cacheMapper.mapFromEntity(dao.getSingleUser(id = id))))

        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }

}