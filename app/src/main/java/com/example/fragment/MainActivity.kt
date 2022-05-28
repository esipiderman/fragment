package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.fragment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = AdapterViewPager(this)
        binding.viewPagerMain.adapter = myAdapter
        binding.viewPagerMain.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPagerMain.offscreenPageLimit = 3

        val mediator = TabLayoutMediator(binding.tabLayout, binding.viewPagerMain, object :TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0->{
                        tab.text = "frag first"
                    }
                    1->{
                        tab.text = "frag second"
                    }
                    2->{
                        tab.text = "frag third"
                    }
                }
            }

        })
        mediator.attach()

    }
}