package com.ase21.somenetworkingoncoroutines

class MainRepository {

    suspend fun getComments() = RetrofitClient.client.getAllCommentsWithAnswers()
}