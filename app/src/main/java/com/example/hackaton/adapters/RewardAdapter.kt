package com.example.hackaton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackaton.R
import com.example.hackaton.data.Reward
import com.example.hackaton.databinding.RewardItemBinding

class RewardAdapter: RecyclerView.Adapter<RewardAdapter.RewardHolder>() {
    val rewardList = ArrayList<Reward>()

    class RewardHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RewardItemBinding.bind(item)
        fun bind(reward: Reward) = with(binding) {
            imvReward.setImageResource(reward.imageId)
            tvTitleReward.text = reward.title
            textView2.text = reward.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reward_item, parent, false)
        return RewardHolder(view)
    }

    override fun onBindViewHolder(holder: RewardHolder, position: Int) {
        holder.bind(rewardList[position])
    }

    override fun getItemCount(): Int {
        return rewardList.size
    }

    fun addReward(reward: Reward) {
        rewardList.add(reward)
        notifyDataSetChanged()
    }
}