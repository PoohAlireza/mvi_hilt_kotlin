package com.alireza.testhilt2.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.alireza.testhilt2.di.AppModule
import com.alireza.testhilt2.ui.main.mainFragment.MainFragment
import com.alireza.testhilt2.ui.main.userFragment.UserFragment
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class MyFragmentFactory @Inject constructor(@AppModule.RealGson private val gson: Gson) : FragmentFactory() {


    @ExperimentalCoroutinesApi
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){

            MainFragment::class.java.name ->{
                MainFragment()
            }

            UserFragment::class.java.name ->{
                UserFragment(gson = gson)
            }
            else -> super.instantiate(classLoader, className)
        }
    }

}