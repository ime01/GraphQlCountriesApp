package com.plcoding.graphqlcountriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.plcoding.graphqlcountriesapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient{
        return ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .build()
    }
}