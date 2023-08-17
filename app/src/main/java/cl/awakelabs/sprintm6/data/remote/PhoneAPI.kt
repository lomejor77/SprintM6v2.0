package cl.awakelabs.sprintm6.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PhoneAPI {
    @GET("products")
    suspend fun getDatas(): retrofit2.Response<List<Phone>>

    @GET("details/{id}")
    suspend fun getPhoneDetails(@Path("id") id:Int) : Response<Detail>
}