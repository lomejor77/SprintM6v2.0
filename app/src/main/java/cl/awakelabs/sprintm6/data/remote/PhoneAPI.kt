package cl.awakelabs.sprintm6.data.remote

import retrofit2.http.GET

interface PhoneAPI {
    @GET("products/")

    suspend fun getData(): retrofit2.Response<List<Phone>>
}