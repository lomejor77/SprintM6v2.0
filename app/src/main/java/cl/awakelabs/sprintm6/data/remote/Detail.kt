package cl.awakelabs.sprintm6.data.remote

data class Detail(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean
)
