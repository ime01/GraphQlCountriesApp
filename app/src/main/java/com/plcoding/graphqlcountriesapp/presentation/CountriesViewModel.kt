package com.plcoding.graphqlcountriesapp.presentation

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.graphqlcountriesapp.domain.DetailedCountry
import com.plcoding.graphqlcountriesapp.domain.SimpleCountry
import com.plcoding.graphqlcountriesapp.domain.getCountriesUseCase
import com.plcoding.graphqlcountriesapp.domain.getCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CountriesViewModel(
    private val getCountriesUseCase: getCountriesUseCase,
    private val getCountryUseCase: getCountryUseCase
): ViewModel() {

     private val _state = MutableStateFlow(CountriesState())
     val state = _state.asStateFlow()

     init {

         viewModelScope.launch {
             _state.update { it.copy(
                 isLoading = true
             ) }

             _state.update { it.copy(
                 countries = getCountriesUseCase.execute(),
                 isLoading = false
             ) }
         }

     }

    fun selectCountry(code:String){
        viewModelScope.launch{
            _state.update { it.copy(
                selectedCountry = getCountryUseCase.execute(code)
            ) }
        }
    }

    fun dismissCountryDialog(){
        _state.update { it.copy(
            selectedCountry = null
        ) }
    }



        data class CountriesState(
            val countries:List<SimpleCountry>  = emptyList(),
            val isLoading: Boolean = false,
            val selectedCountry: DetailedCountry?= null
        )



}