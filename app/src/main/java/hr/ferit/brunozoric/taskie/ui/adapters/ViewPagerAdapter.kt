package hr.ferit.brunozoric.taskie.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.ui.fragments.AboutAppFragment
import hr.ferit.brunozoric.taskie.ui.fragments.AboutAuthorFragment



class ViewPagerAdapter(manager: FragmentManager, context: Context): FragmentPagerAdapter(manager) {

    var mContext = context

    override fun getItem(position: Int): Fragment {
        var fragment = when(position){
            0 -> AboutAppFragment.newInstance()
            1 -> AboutAuthorFragment.newInstance()
            else -> AboutAppFragment.newInstance()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) {
            return mContext.getString(R.string.authorTab)
        } else if (position == 1) {
            return mContext.getString(R.string.aboutTab)
        }
        return mContext.getString(R.string.authorTab)
    }
}