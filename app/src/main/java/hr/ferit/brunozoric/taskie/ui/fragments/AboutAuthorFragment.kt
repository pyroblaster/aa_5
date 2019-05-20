package hr.ferit.brunozoric.taskie.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.brunozoric.taskie.R
import hr.ferit.brunozoric.taskie.ui.fragments.base.BaseFragment

class AboutAuthorFragment:BaseFragment() {
    override fun getLayoutResourceId() = R.layout.fragment_about_author

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResourceId(), container, false)
    }

    companion object {
        fun newInstance(): Fragment {
            return AboutAuthorFragment()
        }
    }
}