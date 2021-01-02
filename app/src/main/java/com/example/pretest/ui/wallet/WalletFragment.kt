package com.example.pretest.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.pretest.base.BaseFragment
import com.example.pretest.databinding.FragmentWalletBinding
import com.example.pretest.getStatusBarHeight
import com.example.pretest.loadUrl
import com.google.android.material.tabs.TabLayoutMediator

class WalletFragment : BaseFragment() {

    private val adapter by lazy { WalletAdapter(activity as AppCompatActivity) }

    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            statusBarView.layoutParams.height = getStatusBarHeight()

            accountIcon.loadUrl("https://event.12cm.com.tw/starbucks/img/siren-l.png")

            viewPager2.apply {
                isUserInputEnabled = true
                offscreenPageLimit = 2
                adapter = this@WalletFragment.adapter
            }

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                tab.text = when (position) {
                    0 -> "容幣紀錄"
                    1 -> "兌換券"
                    else -> ""
                }
                viewPager2.currentItem = tab.position
            }.attach()
        }
    }
}