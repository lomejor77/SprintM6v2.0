package cl.awakelabs.sprintm6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhoneDAO {
    @Insert
    suspend fun insertPhone(phoneEntity: PhoneEntity)

    @Query("select * from tbl_phones order by id asc")
    fun getRace(): LiveData<List<PhoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhones(phoneEntity: List<PhoneEntity>)

    @Query("select * from tbl_phones where id = :id")
    fun getRaceDetail(id: String): LiveData<List<PhoneEntity>>



}