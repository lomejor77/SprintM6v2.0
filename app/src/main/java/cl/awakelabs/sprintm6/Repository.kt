package cl.awakelabs.sprintm6

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelabs.sprintm6.data.local.DetailEntity
import cl.awakelabs.sprintm6.data.local.PhoneDAO
import cl.awakelabs.sprintm6.data.local.PhoneEntity
import cl.awakelabs.sprintm6.data.remote.Detail
import cl.awakelabs.sprintm6.data.remote.Phone
import cl.awakelabs.sprintm6.data.remote.PhoneAPI

class Repository(private val phoneAPI: PhoneAPI, private val phoneDAO: PhoneDAO) {

    fun obtainPhonesEntity(): LiveData<List<PhoneEntity>> = phoneDAO.getPhones()
   //suspend fun
    fun idPhoneDetail(id: Int): LiveData<DetailEntity> = phoneDAO.getPhoneDetail(id)
    suspend fun getPhones(){
        val response = phoneAPI.getDatas()
        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let { phone ->
                val phonesEntity = phone.map { it.transform() }
                phoneDAO.insertPhones(phonesEntity)
            }
        }else{
            Log.e("repositorio", response.errorBody().toString())
        }

    }

   suspend fun obtainIdPhone(id: Int) {
        val response= phoneAPI.getPhoneDetails(id)
        if (response.isSuccessful) {
            val responseBody = response.body()
            responseBody?.let {detailsPhone ->
                val phoneDetailEnt = detailsPhone.transformToDetail()
                phoneDAO.insertDetails(phoneDetailEnt)
            }
        } else {

        }
    }

   // fun obtainIdPhone(id: String): LiveData<PhoneEntity> = phoneDAO.getPhoneDetail(id)
    fun Phone.transform(): PhoneEntity = PhoneEntity(this.id, this.name, this.price, this.image)
    fun Detail.transformToDetail(): DetailEntity = DetailEntity(this.id, this.name, this.price,
        this.image, this.description, this.lastPrice, this.credit)

}
