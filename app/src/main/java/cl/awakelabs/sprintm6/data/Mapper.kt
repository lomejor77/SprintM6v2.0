package cl.awakelabs.sprintm6.data

import cl.awakelabs.sprintm6.data.local.PhoneEntity
import cl.awakelabs.sprintm6.data.remote.Phone

fun Phone.transform(): PhoneEntity =
    PhoneEntity(this.id, this.name, this.price, this.image)
