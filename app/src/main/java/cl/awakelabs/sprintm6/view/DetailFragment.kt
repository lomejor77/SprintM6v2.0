package cl.awakelabs.sprintm6.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.awakelabs.sprintm6.databinding.FragmentDetailBinding
import coil.load

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val phoneViewModel: PhoneViewModel by activityViewModels()
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        phoneViewModel.idPhoneLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.imageDetail.load(it.image)
            binding.detailName.text = it.name
            binding.detailPrice.text = it.price.toString()
        }
        return binding.root
    }

}