package cl.awakelabs.sprintm6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.sprintm6.data.local.PhoneEntity
import cl.awakelabs.sprintm6.databinding.ItemPhoneBinding
import coil.load

class PhoneAdapter: RecyclerView.Adapter<PhoneAdapter.ItemPhoneViewHolder>() {
    lateinit var binding: ItemPhoneBinding
    private val listItemPhones = mutableListOf<PhoneEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhoneAdapter.ItemPhoneViewHolder {
        binding = ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemPhoneViewHolder(binding)

    }
    override fun getItemCount(): Int {
      return listItemPhones.size
    }

    override fun onBindViewHolder(holder: PhoneAdapter.ItemPhoneViewHolder, position: Int) {
        val phone = listItemPhones[position]
        holder.bind(phone)
    }

    fun setData(phone: List<PhoneEntity>) {
        this.listItemPhones.clear()
        this.listItemPhones.addAll(phone)
        notifyDataSetChanged()
    }

    class ItemPhoneViewHolder(private val view: ItemPhoneBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(phone: PhoneEntity) {
            view.imagePhone.load(phone.image)
            view.textName.text = phone.name.toString()
            view.textPrice.text = phone.price.toString()
            view.textId.text = phone.id.toInt().toString()
        }

    }
}