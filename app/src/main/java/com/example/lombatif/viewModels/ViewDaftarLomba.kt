package com.example.lombatif.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lombatif.api.Retrofins
import com.example.lombatif.models.get.DaftarLomba
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewDaftarLomba : ViewModel() {
    private val _lomba = MutableStateFlow<List<DaftarLomba>>(emptyList())
    val lomba: StateFlow<List<DaftarLomba>> = _lomba
    var stateUI by mutableStateOf("")

    init {
        fetchDaftarLomba()
    }

    private fun fetchDaftarLomba() {
        viewModelScope.launch {
            try {
                val response = Retrofins.api.getDaftarLomba()
                _lomba.value = response.daftarLomba
            } catch (e: Exception) {
                Log.e("DaftarLombaView", e.message.toString())
                stateUI = e.message.toString()
            }
        }
    }
}
