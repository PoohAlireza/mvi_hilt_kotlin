package com.alireza.testhilt2.ui.main

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import com.alireza.testhilt2.util.MyFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainNavHostFragment  : NavHostFragment() {


    @Inject
    lateinit var myFragmentFactory: MyFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = myFragmentFactory
    }


}