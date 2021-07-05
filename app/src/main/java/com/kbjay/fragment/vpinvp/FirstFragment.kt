package com.kbjay.fragment.vpinvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kbjay.fragment.vpinvp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private val rootBinding by lazy {
        FragmentFirstBinding.inflate(LayoutInflater.from(requireContext()))
    }
    private var tabTitles: Array<String> = arrayOf("tab_a", "tab_b", "tab_c")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()
        return rootBinding.root
    }

    private fun initView() {
        rootBinding.vp.adapter = object : FragmentStatePagerAdapter(childFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            private var mData: ArrayList<Fragment> = ArrayList()

            init {
                mData.add(ContentFragment())
                mData.add(ContentFragment())
                mData.add(ContentFragment())
            }

            override fun getCount(): Int {
                return mData.size
            }

            override fun getItem(position: Int): Fragment {
                return mData[position]
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return tabTitles[position]
            }

        }

        rootBinding.tab.setupWithViewPager(rootBinding.vp)
    }
}