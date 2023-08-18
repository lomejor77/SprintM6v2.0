package cl.awakelabs.sprintm6.view

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.sprintm6.R
import cl.awakelabs.sprintm6.Repository
import cl.awakelabs.sprintm6.data.local.DetailEntity
import cl.awakelabs.sprintm6.data.local.PhoneDataBase
import cl.awakelabs.sprintm6.data.local.PhoneEntity
import cl.awakelabs.sprintm6.data.remote.PhoneRetroFit
import kotlinx.coroutines.launch

class PhoneViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository

    init {
        val api = PhoneRetroFit.getRetroFitClient()
        val phoneDataBase = PhoneDataBase.getDataBase(application).getPhoneDao()

        repository = Repository(api, phoneDataBase)
    }
    fun getAllPhones() = viewModelScope.launch { repository.getPhones() }
    fun phonesLiveData() = repository.obtainPhonesEntity()//obtiene lista para mostrar en home

    /**metodo en oncreateview de detailfragment*/
    fun getDetails(id: Int) = viewModelScope.launch { repository.obtainIdPhone(id) }

    //datos al detalle viene desde el repositorio
    fun idPhoneLiveData(id: Int) = repository.idPhoneDetail(id)

    fun detailLiveData(id: Int): LiveData<DetailEntity> = repository.idPhoneDetail(id)

    fun sendEmail(context:Context, name: String, selectedId: Int) {

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            //putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
            putExtra(Intent.EXTRA_EMAIL, arrayOf(R.string.send_to))
            putExtra(Intent.EXTRA_SUBJECT, "Consulta $name id $selectedId")
            putExtra(
                Intent.EXTRA_TEXT,
                "Hola\n Vi el producto " + name + " de código " + selectedId +
                        "y me gustaría que me contactaran a este correo o al siguiente número ___. " +
                        "\n Quedo atento.")
        }
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }

    }
}