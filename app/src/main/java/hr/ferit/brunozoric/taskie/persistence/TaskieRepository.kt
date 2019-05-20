package hr.ferit.brunozoric.taskie.persistence

import hr.ferit.brunozoric.taskie.model.Task

interface TaskieRepository{
    fun getAllTasks(): List<Task>
    fun addTask(task: Task)
    fun delteTask(task: Task)
}