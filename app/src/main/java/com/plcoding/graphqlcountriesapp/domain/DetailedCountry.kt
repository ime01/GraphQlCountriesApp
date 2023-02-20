package com.plcoding.graphqlcountriesapp.domain

import com.plcoding.type.Continent
import java.util.Currency

data class DetailedCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)

