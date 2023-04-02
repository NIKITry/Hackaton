package com.example.hackaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackaton.R
import com.example.hackaton.adapters.TestAdapter
import com.example.hackaton.data.Test

import com.example.hackaton.databinding.FragmentTaskTestBinding

class TestFragment: Fragment() {
    private var _binding: FragmentTaskTestBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter = TestAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTaskTestBinding.inflate(inflater, container, false)
        val view = binding.root
        init()
        return view
    }

    private fun init() = with(binding) {
        rvTest.layoutManager = LinearLayoutManager(this@TestFragment.context)
        rvTest.adapter = adapter
        adapter.addTest(Test("[вопрос с вариантом ответа]", 1, "[...]", "[...]", "[...]"))
        adapter.addTest(Test("[вопрос с выбором пропущенного слова]", 2, "[...]", "[...]", "[...]"))
        adapter.addTest(Test("[вопрос с вариантом ответа]", 3, "[...]", "[...]", "[...]"))
        adapter.addTest(Test("[вопрос с вариантом ответа]", 4, "[...]", "[...]", "[...]"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = TestFragment()
    }
}