package cl.awakelabs.sprintm6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.sprintm6.Repository
import cl.awakelabs.sprintm6.data.local.PhoneDAO
import cl.awakelabs.sprintm6.data.local.PhoneDataBase
import cl.awakelabs.sprintm6.data.local.PhoneEntity
import cl.awakelabs.sprintm6.data.remote.PhoneRetroFit
import kotlinx.coroutines.launch

class PhoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    fun phonesLiveData() = repository.obtainPhonesEntity()

    init {
        val api = PhoneRetroFit.getRetroFitClient()
        val phoneDataBase: PhoneDAO = PhoneDataBase.getDataBase(application).getPhoneDao()
        repository = Repository(api, phoneDataBase)
    }

    fun getAllPhones() = viewModelScope.launch { repository.getPhones() }
    //fun phonesLiveData() = repository.obtainPhonesEntity()
    //fun idPhoneLiveData(id: String) = repository.obtainDetailEntity(id)
}