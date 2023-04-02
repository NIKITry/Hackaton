package com.example.hackaton.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackaton.ExpandableListViewAdapter
import com.example.hackaton.R
import com.example.hackaton.databinding.FragmentCollegesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MaterialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollegesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var groupList = ArrayList<String>()
    private var materialsCollection = HashMap<String, List<String>>()
    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var binding: FragmentCollegesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCollegesBinding.inflate(inflater, container, false)
        createCollection()
        listViewAdapter =
            activity?.let { ExpandableListViewAdapter(it.baseContext, groupList, materialsCollection) }!!
        binding.listView.setAdapter(listViewAdapter)
        return binding.root
    }

    private fun createGroupList() {
        groupList.add(getString(R.string.person_1))
        groupList.add(getString(R.string.person_2))
        groupList.add(getString(R.string.person_3))
        groupList.add(getString(R.string.person_4))
    }

    private fun createCollection() {
        createGroupList()
        val firstGroup = listOf(getString(R.string.bio_info))
        materialsCollection[groupList[0]] = firstGroup
        materialsCollection[groupList[1]] = firstGroup
        materialsCollection[groupList[2]] = firstGroup
        materialsCollection[groupList[3]] = firstGroup
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MaterialFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaterialFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}