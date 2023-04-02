package com.example.hackaton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackaton.R
import com.example.hackaton.data.Video
import com.example.hackaton.databinding.VideoItemBinding


class VideoAdapter: RecyclerView.Adapter<VideoAdapter.VideoHolder>() {
    val testList = ArrayList<Video>()

    class VideoHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = VideoItemBinding.bind(item)
        fun bind(test: Video) = with(binding) {
            tvVideo.text = test.name
            videoView.setImageResource(test.videoId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideoHolder(view)
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        holder.bind(testList[position])
    }

    override fun getItemCount(): Int {
        return testList.size
    }

    fun addTest(test: Video) {
        testList.add(test)
        notifyDataSetChanged()
    }
}