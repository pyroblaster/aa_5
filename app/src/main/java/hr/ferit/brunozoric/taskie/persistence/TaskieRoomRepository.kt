package hr.ferit.brunozoric.taskie.persistence

import hr.ferit.brunozoric.taskie.Taskie
import hr.ferit.brunozoric.taskie.db.DaoProvider
import hr.ferit.brunozoric.taskie.model.Priority
import hr.ferit.brunozoric.taskie.model.Task

class TaskieRoomRepository : TaskieRepository{
    private var db = DaoProvider.getInstance(Taskie.getAppContext())

    private var taskieDao = db.taskieDao()

    override fun getTask(id: Int): Task = taskieDao.getTask(id)
    override fun getAllTasks(): MutableList<Task> = taskieDao.getAllTasks()
    override fun addTask(task: Task) = taskieDao.addTask(task)
    override fun deleteTask(task: Task) = taskieDao.deleteTask(task)

    override fun editTask(task: Task, title: String, desc: String, priority: Priority) {
        taskieDao.changeTitle(task.id,title)
        taskieDao.changeDesc(task.id,desc)
        taskieDao.changePriority(task.id,priority)
    }
}