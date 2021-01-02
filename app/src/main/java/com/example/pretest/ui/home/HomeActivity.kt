package com.example.pretest.ui.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.pretest.R
import com.example.pretest.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.LabelVisibilityMode

class HomeActivity : AppCompatActivity() {

    private val adapter by lazy { HomePager2Adapter(this) }

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        with(binding) {
            viewPager2.apply {
                isUserInputEnabled = false
                offscreenPageLimit = this@HomeActivity.adapter.itemCount
                adapter = this@HomeActivity.adapter
            }

            bottomNavView.menu.apply {
                clear()
                add(Menu.NONE, R.id.home_call, 0, "電話").setIcon(R.mipmap.browser)
                add(Menu.NONE, R.id.home_chat, 1, "聊天").setIcon(R.mipmap.icon_trending)
                add(Menu.NONE, R.id.home_scanner, 2, "掃描").setIcon(R.mipmap.portfolio)
                add(Menu.NONE, R.id.home_explore, 3, "滑吧").setIcon(R.mipmap.account)
                add(Menu.NONE, R.id.home_wallet, 4, "錢包").setIcon(R.mipmap.wallet)
            }

            bottomNavView.apply {
                labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

                setOnNavigationItemSelectedListener { item ->
                    viewPager2.setCurrentItem(item.order, false)
                    return@setOnNavigationItemSelectedListener true
                }
                selectedItemId = R.id.home_wallet
                viewPager2.setCurrentItem(4, false)
            }
        }
    }
}