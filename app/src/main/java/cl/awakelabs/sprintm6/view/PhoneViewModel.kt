package cl.awakelabs.sprintm6.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelabs.sprintm6.Repository
import cl.awakelabs.sprintm6.data.local.PhoneDataBase
import cl.awakelabs.sprintm6.data.remote.PhoneRetroFit
import kotlinx.coroutines.launch

class PhoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository


    init {
        val api = PhoneRetroFit.getRetroFitClient()
        val phoneDataBase = PhoneDataBase.getDataBase(application).getPhoneDao()
        repository = Repository(api, phoneDataBase)
    }
    fun phonesLiveData() = repository.obtainPhonesEntity()
    fun getAllPhones() = viewModelScope.launch { repository.getPhones() }
    //fun phonesLiveData() = repository.obtainPhonesEntity()
    fun idPhoneLiveData(id: String) = repository.obtainIdPhone(id)
}