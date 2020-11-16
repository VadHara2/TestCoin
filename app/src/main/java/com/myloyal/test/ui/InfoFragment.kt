package com.myloyal.test.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.myloyal.test.R
import com.myloyal.test.data.Api
import com.myloyal.test.data.ApiModule
import com.myloyal.test.models.Currency
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import com.myloyal.test.databinding.FragmentInfoBinding as FragmentInfoBinding

class InfoFragment : Fragment(), InfoNavigator {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        val viewmodel = ViewModelProvider(this).get(InfoViewModel::class.java)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner =this
        viewmodel.getInfo()
        viewmodel.navigator = this

        return  binding.root
    }



}