package com.example.hackaton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackaton.R
import com.example.hackaton.data.Reward
import com.example.hackaton.data.Test
import com.example.hackaton.data.TestImg
import com.example.hackaton.databinding.FragmentTaskImgTestBinding
import com.example.hackaton.databinding.TestItemBinding
import com.example.hackaton.databinding.TestItemImageBinding


class TestImgAdapter: RecyclerView.Adapter<TestImgAdapter.TestImgHolder>() {
    val testList = ArrayList<TestImg>()

    class TestImgHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = TestItemImageBinding.bind(item)
        fun bind(test: TestImg) = with(binding) {
            tvQuestionFirst.text = "Вопрос " + test.index + ":"
            imageView.setImageResource(test.imgId)
            tvQuestion.text = test.question
            tvVarFirst.text = "a) " + test.firstV
            tvVarSec.text = "б) " + test.secondV
            tvVarThird.text = "в) " + test.thirdV
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestImgHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_item_image, parent, false)
        return TestImgHolder(view)
    }

    override fun onBindViewHolder(holder: TestImgHolder, position: Int) {
        holder.bind(testList[position])
    }

    override fun getItemCount(): Int {
        return testList.size
    }

    fun addTest(test: TestImg) {
        testList.add(test)
        notifyDataSetChanged()
    }
}