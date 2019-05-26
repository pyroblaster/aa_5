package hr.ferit.brunozoric.taskie.ui.activities

import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.common.showFragment
import hr.ferit.brunozoric.taskie.ui.activities.base.BaseActivity
import hr.ferit.brunozoric.taskie.ui.fragments.ClearAllListeners
import hr.ferit.brunozoric.taskie.ui.fragments.SortTasks
import hr.ferit.brunozoric.taskie.ui.fragments.TasksFragment
import hr.ferit.brunozoric.taskie.ui.fragments.ViewPagerFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener, TasksFragment.setListener{

    override fun getLayoutResourceId() = R.layout.activity_main

    override fun setUpUi() {
        showFragment(TasksFragment.newInstance())
        bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_tasks ->{
                showFragment(R.id.fragmentContainer, TasksFragment())
            }
            R.id.navigation_about ->{
                showFragment(R.id.fragmentContainer, ViewPagerFragment())
            }

        }
        return true
    }

    private var clearAllListeners:ClearAllListeners? = null
    private var sortT: SortTasks? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        supportFragmentManager.fragments.last()?.let {
            if (it is TasksFragment) {
                menuInflater.inflate(R.menu.menu_layout, menu)
            }
        }
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.deleteAllTasks -> callDeleteTasks()
            R.id.sortTasks -> sort()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sort() {
        sortT!!.sortTasks()
    }

    override fun setListener(fragment: TasksFragment) {
        clearAllListeners = fragment
        sortT = fragment
    }

    private fun callDeleteTasks(){
        clearAllListeners!!.deletAllTasks()
    }

}