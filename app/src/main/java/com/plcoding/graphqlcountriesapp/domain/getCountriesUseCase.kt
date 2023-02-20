package com.plcoding.graphqlcountriesapp.domain

class getCountriesUseCase(private val countryClient: CountryClient) {

    suspend fun execute(): List<SimpleCountry>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}