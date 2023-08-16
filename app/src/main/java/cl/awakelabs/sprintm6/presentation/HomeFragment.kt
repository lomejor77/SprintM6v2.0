package cl.awakelabs.sprintm6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.sprintm6.R
import cl.awakelabs.sprintm6.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
     lateinit var binding: FragmentHomeBinding
     private val viewModel: PhoneViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel.getAllPhones()
        loadData()
        return binding.root
    }

    private fun loadData() {
        val adapter = PhoneAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.phonesLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


}