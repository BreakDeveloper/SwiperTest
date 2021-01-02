package com.example.pretest.ui.text

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pretest.PASS_NUMBER
import com.example.pretest.base.BaseFragment
import com.example.pretest.databinding.FragmentTextBinding
import com.example.pretest.getBundleValue

class TextFragment : BaseFragment() {

    private val pageNumber by getBundleValue(PASS_NUMBER, -1)

    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            fragmentTitle.text = "This is fragment $pageNumber"
        }
    }
}