package com.example.myapplicationthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplicationthree.model.networking.RetrofitBuilder
import com.example.myapplicationthree.model.Senator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExampleViewModel: ViewModel() {
    private var senatorsMutableLiveData = MutableLiveData<List<Senator>>()
    val senatorLiveData: LiveData<List<Senator>>
        get() = senatorsMutableLiveData

    fun loadSenators() {
        val retrofit = RetrofitBuilder().getRetrofit("https://www.govtrack.us/")

        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofit.getSenators("true", "senator")
            withContext(Dispatchers.Main) {
                senatorsMutableLiveData.postValue(response.objects)
            }
        }
    }
}