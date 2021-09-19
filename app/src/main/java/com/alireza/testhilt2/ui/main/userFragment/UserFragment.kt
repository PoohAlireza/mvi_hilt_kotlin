package com.alireza.testhilt2.ui.main.userFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.alireza.testhilt2.R
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.util.DataState
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class UserFragment constructor(private val gson: Gson) : Fragment(R.layout.fragment_user) {

    private lateinit var text: TextView
    private lateinit var progress_bar: ProgressBar

    // auto inject
    private val userViewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        observe()
        userViewModel.setData(UserStateEvent.GetUsers(getUserId()))

    }


    private fun observe(){
        userViewModel.dataState.observe(viewLifecycleOwner, Observer {
            when(it){
                is DataState.Loading ->{
                    displayProgress(true)
                }
                is DataState.Error ->{
                    displayProgress(false)
                    displayError(it.exception.message)
                }
                is DataState.Success ->{
                    displayProgress(false)
                    displayUserInfo(it.data)
                }
            }
        })
    }

    private fun getUserId():Int{
        return requireArguments().getInt("id")
    }

    private fun init(view: View){
        text = view.findViewById(R.id.tv_user_fragment)
        progress_bar = view.findViewById(R.id.progress_bar_user)
    }

    private fun displayUserInfo(user:User){
        text.text = "<<User Information>>\nid : ${user.id}\nname : ${user.name}\nusername : ${user.username}\nphone : ${user.phone}\nemail : ${user.email}\nwebsite : ${user.website}\n\n"+
        "<<Company>>\nname : ${user.company.name}\ncatchPhrase : ${user.company.catchPhrase}\nbs : ${user.company.bs}\n\n"+
        "<<Address>>\ncity : ${user.address.city}\nstreet : ${user.address.street}\nsuite : ${user.address.suite}\nzip code : ${user.address.zipcode}\n"+
        "\t<<Geo>>\n\tlat : ${user.address.geo.lat}\n\tlng : ${user.address.geo.lng}"
    }

    private fun displayError(message:String?){
        if (message!=null){
            text.text = message
        }else{
            text.text ="Unknown Error"
        }
    }

    private fun displayProgress(isDisplayed:Boolean){
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }


}