package com.alireza.testhilt2.ui.main.userFragment

sealed class UserStateEvent<out R> {

    class GetUsers<out T>(val id:T): UserStateEvent<T>()

}
