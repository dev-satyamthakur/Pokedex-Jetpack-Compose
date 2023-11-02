package com.satyamthakur.learning.pokedexcompose.di

import com.satyamthakur.learning.pokedexcompose.data.remote.PokeAPI
import com.satyamthakur.learning.pokedexcompose.repository.PokemonRepository
import com.satyamthakur.learning.pokedexcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    fun providePokemonRepository(
        api: PokeAPI
    ) = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokeAPI = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(PokeAPI::class.java)

}