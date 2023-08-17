package cl.awakelabs.sprintm6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhoneDAO {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhone(phoneEntity: PhoneEntity)

    @Query("SELECT * FROM tbl_phones ORDER BY id ASC")
    fun getPhones(): LiveData<List<PhoneEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhones(phoneEntity: List<PhoneEntity>)

    @Query("SELECT * FROM tbl_phones WHERE id = :id")
    fun getPhoneDetail(id: String): LiveData<PhoneEntity>



}