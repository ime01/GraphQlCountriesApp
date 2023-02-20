package com.plcoding.graphqlcountriesapp.domain

class getCountryUseCase(private val countryClient: CountryClient) {

    suspend fun execute(code:String): DetailedCountry?{
        return countryClient.getCountry(code)
    }
}