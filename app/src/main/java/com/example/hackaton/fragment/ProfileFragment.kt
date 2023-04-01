package com.example.hackaton.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackaton.R
import com.example.hackaton.adapters.RewardAdapter
import com.example.hackaton.data.Reward
import com.example.hackaton.databinding.FragmentProfileBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentProfileBinding
    private val adapter = RewardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private fun init() = with(binding) {
        rvRewards.layoutManager = LinearLayoutManager(this@ProfileFragment.context)
        rvRewards.adapter = adapter
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward_lock, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward_lock, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward_lock, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward_lock, "Some Reward", "Some Description"))
        adapter.addReward(Reward(R.drawable.reward_lock, "Some Reward", "Some Description"))

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ProfileFragment()
    }
}