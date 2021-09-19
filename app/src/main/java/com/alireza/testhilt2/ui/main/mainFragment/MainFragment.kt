package com.alireza.testhilt2.ui.main.mainFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alireza.testhilt2.R
import com.alireza.testhilt2.model.User
import com.alireza.testhilt2.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val TAG:String = "MainFragment"

    // auto inject
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var text: TextView
    private lateinit var progress_bar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        observe()
        mainViewModel.setState(MainStateEvent.GetUsersEvent)

    }




    private fun init(view: View){
        text = view.findViewById(R.id.text_error)
        progress_bar = view.findViewById(R.id.progress_bar)
        recyclerView = view.findViewById(R.id.rv_main)
    }

    private fun observe() {
        mainViewModel.dataState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Loading -> {
                    displayProgress(true)
                }
                is DataState.Success -> {
                    displayProgress(false)
                    setupUserListView(it.data)
                }
                is DataState.Error -> {
                    displayProgress(false)
                    displayError(it.exception.message)
                    Log.i(TAG, "observe: "+it.exception.message)
                }
            }
        })
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

    private fun setupUserListView(users:List<User>){
        recyclerView.layoutManager = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        recyclerView.adapter = MainAdapter(users = users,context = context)
        recyclerView.visibility = View.VISIBLE
    }


}