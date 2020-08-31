package com.ase21.somenetworkingoncoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ase21.somenetworkingoncoroutines.data.ShopRateDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val rep = MainRepository()

    val shopRateDTOs = MutableLiveData<List<ShopRateDTO?>>()

    fun getRates(){
        CoroutineScope(Dispatchers.Main).launch {
            shopRateDTOs.postValue(rep.getComments())
        }
    }
}