package hr.ferit.brunozoric.taskie.persistence

import hr.ferit.brunozoric.taskie.Taskie
import hr.ferit.brunozoric.taskie.db.DaoProvider
import hr.ferit.brunozoric.taskie.model.Task

class TaskieRoomRepository : TaskieRepository{

    private var db = DaoProvider.getInstance(Taskie.getAppContext())

    private var taskieDao = db.taskieDao()


    override fun getAllTasks(): List<Task> = taskieDao.getAllTasks()
    override fun addTask(task: Task) = taskieDao.addTask(task)
    override fun delteTask(task: Task) = taskieDao.delteTask(task)

}