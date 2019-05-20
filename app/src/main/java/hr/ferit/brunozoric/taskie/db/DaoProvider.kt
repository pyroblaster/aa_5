package hr.ferit.brunozoric.taskie.db

import androidx.room.*
import android.content.Context
import hr.ferit.brunozoric.taskie.model.Task

@Database(entities = [Task::class], version = 1)
abstract class DaoProvider : RoomDatabase() {

    abstract fun taskieDao(): TaskieDao

    companion object {
        private var instance: DaoProvider? = null

        fun getInstance(context: Context): DaoProvider {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaoProvider::class.java,
                    "TaskDb"
                ).allowMainThreadQueries().build()
            }
            return instance as DaoProvider
        }
    }
}