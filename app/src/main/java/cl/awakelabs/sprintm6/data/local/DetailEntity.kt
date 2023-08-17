package cl.awakelabs.sprintm6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_details")
data class DetailEntity (
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean
)