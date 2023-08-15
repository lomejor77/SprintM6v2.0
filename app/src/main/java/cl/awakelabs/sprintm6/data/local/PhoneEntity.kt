package cl.awakelabs.sprintm6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_phones")
class PhoneEntity (
    @PrimaryKey
    val id: String,
    val name: String,
    val price: Int,
    val image: String
)