package cl.awakelabs.sprintm6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhoneRetroFit {
    companion object{
        private const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"
        fun getRetroFitClient() : PhoneAPI{
            val mRetroFit = Retrofit.Builder().baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return mRetroFit.create(PhoneAPI::class.java)
        }
    }
}