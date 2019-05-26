package hr.ferit.brunozoric.taskie.ui.fragments

import android.os.Bundle
import android.view.View
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.common.EXTRA_TASK_ID
import hr.ferit.brunozoric.taskie.common.displayToast
import hr.ferit.brunozoric.taskie.model.Task
import hr.ferit.brunozoric.taskie.persistence.TaskieRoomRepository
import hr.ferit.brunozoric.taskie.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_task_details.*


class TaskDetailsFragment : BaseFragment(),UpdateTaskFragmentDialog.UpdateTaskLIstener {

    private val repository = TaskieRoomRepository()
    private var taskID = NO_TASK

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_task_details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt(EXTRA_TASK_ID)?.let { taskID = it }
        tryDisplayTask(taskID)
        initListeners()

    }
    override fun onTaskEdited(task: Task) {
        tryDisplayTask(id)
    }

    private fun initListeners() {
        updateTaskButton.setOnClickListener { updateTask() }
    }


    private fun tryDisplayTask(id: Int) {
        try {
            val task = repository.getTask(id)
            displayTask(task)
        } catch (e: NoSuchElementException) {
            context?.displayToast(getString(R.string.noTaskFound))
        }
    }

    private fun displayTask(task: Task) {
        detailsTaskTitle.text = task.title
        detailsTaskDescription.text = task.description
        detailsPriorityView.setBackgroundResource(task.priority.getColor())
    }

    private fun updateTask() {
        val updateTaskDialog = UpdateTaskFragmentDialog.newInstance(taskID)
        updateTaskDialog.setUpdateTaskLIstener(this)
        updateTaskDialog.show(childFragmentManager,updateTaskDialog.tag)

    }


    companion object {
        const val NO_TASK = -1

        fun newInstance(taskId: Int): TaskDetailsFragment {
            val bundle = Bundle().apply { putInt(EXTRA_TASK_ID, taskId) }
            return TaskDetailsFragment().apply { arguments = bundle }
        }
    }
}
