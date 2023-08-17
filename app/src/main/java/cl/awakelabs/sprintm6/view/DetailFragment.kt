package cl.awakelabs.sprintm6.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelabs.sprintm6.R
import cl.awakelabs.sprintm6.databinding.FragmentDetailBinding
import coil.load

private const val ARG_PARAM1 = "id"

class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val phoneViewModel: PhoneViewModel by activityViewModels()
    //private var param1: String? = null
    private  var selectId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectId = it.getInt(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        phoneViewModel.getDetails(selectId)

        loadDetails()
        return binding.root
    }

    private fun loadDetails() {
        phoneViewModel.idPhoneLiveData(selectId).observe(viewLifecycleOwner){
            if (it != null){
                binding.imageDetail.load(it.image)
                binding.detailName.text = it.name
                binding.detailPrice.text = "Precio ref: $ ${it.price}"
                binding.textLastPrice.text = "Precio Oferta: $ ${it.lastPrice}"
                binding.textDescription.text = it.description

                val creditValue: String = if (it.credit) {
                    "*24 cuotas"
                } else {
                    "Sólo Efectivo"
                }

                binding.textCredits.text = creditValue
            }

        }
    }

}