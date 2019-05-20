package hr.ferit.brunozoric.taskie.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.ui.adapters.ViewPagerAdapter
import hr.ferit.brunozoric.taskie.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_view_pager.*

class ViewPagerFragment: BaseFragment(){

    override fun getLayoutResourceId() = R.layout.fragment_view_pager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        viewPager.adapter = ViewPagerAdapter(childFragmentManager, context!!)
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        fun newInstance(): Fragment {
            return ViewPagerFragment()
        }
    }

}