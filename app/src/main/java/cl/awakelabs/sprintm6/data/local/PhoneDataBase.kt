package cl.awakelabs.sprintm6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PhoneEntity::class, DetailEntity::class], version = 1)
abstract class PhoneDataBase: RoomDatabase() {
    abstract fun getPhoneDao(): PhoneDAO
    companion object{
        @Volatile
        private var INSTANCE: PhoneDataBase? = null

        fun getDataBase(context: Context): PhoneDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PhoneDataBase::class.java,
                    "phones_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }


    }
}