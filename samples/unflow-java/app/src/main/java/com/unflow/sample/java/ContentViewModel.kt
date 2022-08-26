package com.unflow.sample.java

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unflow.androidsdk.UnflowSdk
import com.unflow.androidsdk.ui.opener.OpenerData
import kotlinx.coroutines.launch

class ContentViewModel : ViewModel() {
    private val openers: MutableLiveData<List<OpenerData>> by lazy {
        MutableLiveData<List<OpenerData>>().also {
            viewModelScope.launch {
                fetchOpeners()
            }
        }
    }

    fun getOpeners(): LiveData<List<OpenerData>> {
        return openers
    }

    private suspend fun fetchOpeners() {
        UnflowSdk.client().openers().collect {
            openers.value = it
        }
    }
}