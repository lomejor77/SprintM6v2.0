package cl.awakelabs.sprintm6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_phones")
data class PhoneEntity(
    @PrimaryKey val id: String,
    val name: Int,
    val price: Int,
    val image: String
)