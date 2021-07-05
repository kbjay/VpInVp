package com.kbjay.fragment.vpinvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kbjay.fragment.vpinvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val rootBinding by lazy {
        ActivityMainBinding.inflate(LayoutInflater.from(this))
    }
    private var tabTitles: Array<String> = arrayOf("tab1", "tab2")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(rootBinding.root)

        rootBinding.vp.adapter = object : FragmentStatePagerAdapter(supportFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            private var mData: ArrayList<Fragment> = ArrayList()

            init {
                mData.add(FirstFragment())
                mData.add(SecondFragment())
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