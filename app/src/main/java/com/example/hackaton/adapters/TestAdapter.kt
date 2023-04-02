package com.example.hackaton.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackaton.R
import com.example.hackaton.data.Reward
import com.example.hackaton.data.Test
import com.example.hackaton.databinding.TestItemBinding


class TestAdapter: RecyclerView.Adapter<TestAdapter.TestHolder>() {
    val testList = ArrayList<Test>()

    class TestHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = TestItemBinding.bind(item)
        fun bind(test: Test) = with(binding) {
            tvQuestionFirst.text = "Вопрос " + test.index + ":"
            tvQuestion.text = test.question
            tvVarFirst.text = "a) " + test.firstV
            tvVarSec.text = "б) " + test.secondV
            tvVarThird.text = "в) " + test.thirdV
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_item, parent, false)
        return TestHolder(view)
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        holder.bind(testList[position])
    }

    override fun getItemCount(): Int {
        return testList.size
    }

    fun addTest(test: Test) {
        testList.add(test)
        notifyDataSetChanged()
    }
}
