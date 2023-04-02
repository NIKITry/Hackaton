package com.example.hackaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackaton.R
import com.example.hackaton.adapters.TestImgAdapter
import com.example.hackaton.adapters.VideoAdapter
import com.example.hackaton.data.TestImg
import com.example.hackaton.data.Video
import com.example.hackaton.databinding.FragmentTaskImgTestBinding
import com.example.hackaton.databinding.FragmentVideoTaskBinding

class VideoFragment: Fragment() {
    private var _binding: FragmentVideoTaskBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val adapter = VideoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVideoTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        init()
        return view
    }

    private fun init() = with(binding) {
        rvTest.layoutManager = LinearLayoutManager(this@VideoFragment.context)
        rvTest.adapter = adapter
        adapter.addTest(Video("Видео-материал", R.drawable.video_task))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = VideoFragment()
    }
}