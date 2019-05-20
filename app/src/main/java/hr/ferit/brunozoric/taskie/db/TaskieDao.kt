package hr.ferit.brunozoric.taskie.db

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE

import hr.ferit.brunozoric.taskie.model.Task

@Dao
interface TaskieDao {

    @Query("SELECT * FROM Task")
    fun getAllTasks(): List<Task>

    @Insert(onConflict = IGNORE)
    fun addTask(task: Task)

    @Delete
    fun delteTask(task: Task)
}