package hr.ferit.brunozoric.taskie.persistence

import hr.ferit.brunozoric.taskie.model.Priority
import hr.ferit.brunozoric.taskie.model.Task

interface TaskieRepository{
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
    fun deleteTask(task: Task)
    fun editTask(task:Task, title:String, desc:String, priority: Priority)
}