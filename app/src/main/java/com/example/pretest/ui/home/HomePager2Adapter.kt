package com.example.pretest.ui.home

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pretest.PASS_NUMBER
import com.example.pretest.ui.text.TextFragment
import com.example.pretest.ui.wallet.WalletFragment
import com.example.pretest.withBundleValue

class HomePager2Adapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 5

    override fun createFragment(position: Int) = when (position) {
        4 -> WalletFragment()
        else -> TextFragment().withBundleValue {
            putInt(PASS_NUMBER, position)
        }
    }
}