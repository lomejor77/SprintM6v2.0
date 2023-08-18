package cl.awakelabs.sprintm6.data

import cl.awakelabs.sprintm6.data.remote.Phone
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun transform() {
        //given(dado)
        val id = "id"
        val phone = Phone(id,"nombre",123,"srcImg")

        //when(cuando)
        val result =phone.transform()

        //then(entonces)
        assertEquals(result.id, phone.id)
        assertEquals(result.name, phone.name)
        assertEquals(result.price, phone.price)
        assertEquals(result.image, phone.image)
    }
}