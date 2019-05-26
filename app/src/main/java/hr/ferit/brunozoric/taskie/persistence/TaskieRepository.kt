package hr.ferit.brunozoric.taskie.persistence

import hr.ferit.brunozoric.taskie.model.Priority
import hr.ferit.brunozoric.taskie.model.Task

interface TaskieRepository{
    fun getTask(id:Int): Task
    fun getAllTasks(): MutableList<Task>
    fun addTask(task: Task)
    fun deleteTask(task: Task)
    fun deleteAllTasks()
    fun editTask(task:Task, title:String, desc:String, priority: Priority)
}