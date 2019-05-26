package hr.ferit.brunozoric.taskie.db

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import hr.ferit.brunozoric.taskie.model.Priority

import hr.ferit.brunozoric.taskie.model.Task

@Dao
interface TaskieDao {

    @Query("SELECT * FROM Task WHERE id =:id")
    fun getTask(id: Int):Task

    @Query("SELECT * FROM Task")
    fun getAllTasks(): MutableList<Task>

    @Insert(onConflict = IGNORE)
    fun addTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("UPDATE task SET title =:title WHERE id = :id")
    fun changeTitle(id: Int,title: String)

    @Query("UPDATE task SET description =:desc WHERE id = :id")
    fun changeDesc(id: Int,desc: String)

    @Query("UPDATE task SET priority =:priority WHERE id = :id")
    fun changePriority(id: Int,priority: Priority)
}