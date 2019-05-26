package hr.ferit.brunozoric.taskie.ui.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.common.displayToast
import hr.ferit.brunozoric.taskie.model.Priority
import hr.ferit.brunozoric.taskie.model.Task
import hr.ferit.brunozoric.taskie.persistence.TaskieRoomRepository
import kotlinx.android.synthetic.main.fragment_update_task.*

class UpdateTaskFragmentDialog(var i: Int):DialogFragment(){

private val repository = TaskieRoomRepository()
private var updateTaskListener: UpdateTaskLIstener? = null
lateinit var task: Task

interface UpdateTaskLIstener {
    fun onTaskEdited(task: Task)
}

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}

fun setUpdateTaskLIstener(listener: UpdateTaskLIstener){
    updateTaskListener = listener
}

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_update_task, container)
}

override fun onStart() {
    super.onStart()
    dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initUi()
    initListeners()
}

private fun initUi(){
    task = repository.getTask(id)

    context?.let {
        taskPriorityUpdate.adapter = ArrayAdapter<Priority>(it, android.R.layout.simple_spinner_dropdown_item, Priority.values())
        taskPriorityUpdate.setSelection(0)
    }
    tasktTitleUpdate.setText(task.title)
    taskDescUpdate.setText(task.description)
}

private fun initListeners(){
    saveTaskUpdate.setOnClickListener{ editTask() }
}

private fun editTask() {
    if (isInputEmpty()){
        context?.displayToast(getString(R.string.emptyFields))
        return
    }
    val title = tasktTitleUpdate.text.toString()
    val description = taskDescUpdate.text.toString()
    val priority = taskPriorityUpdate.selectedItem as Priority
    repository.editTask(task,title,description,priority)
    clearUi()
    updateTaskListener?.onTaskEdited(task)
    dismiss()
}


private fun clearUi() {
    tasktTitleUpdate.text.clear()
    taskDescUpdate.text.clear()
    taskPriorityUpdate.setSelection(0)
}


private fun isInputEmpty(): Boolean = TextUtils.isEmpty(tasktTitleUpdate.text) || TextUtils.isEmpty(
    taskDescUpdate.text
)

companion object{
    fun newInstance(id: Int)= UpdateTaskFragmentDialog (id)
}
}
