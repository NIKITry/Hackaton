package com.example.hackaton.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackaton.ExpandableListViewAdapter
import com.example.hackaton.R
import com.example.hackaton.databinding.MaterialsLayoutFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MaterialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MaterialFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var groupList = ArrayList<String>()
    private var materialsCollection = HashMap<String, List<String>>()
    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var binding: MaterialsLayoutFragmentBinding

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
        binding = MaterialsLayoutFragmentBinding.inflate(inflater, container, false)
        createCollection()
        listViewAdapter =
            activity?.let { ExpandableListViewAdapter(it.baseContext, groupList, materialsCollection) }!!
        binding.listView.setAdapter(listViewAdapter)
        return binding.root
    }

        private fun createGroupList() {
        groupList.add(getString(R.string.group_item_1))
        groupList.add(getString(R.string.group_item_2))
        groupList.add(getString(R.string.group_item_3))
        groupList.add(getString(R.string.group_item_4))
        groupList.add(getString(R.string.group_item_5))
    }

    private fun createCollection() {
        createGroupList()
        val firstGroup = listOf(getString(R.string.item_list_1), getString(R.string.item_list_2), getString(R.string.item_list_3))
        val secondGroup = listOf(getString(R.string.item_list_4), getString(R.string.item_list_5))
        val thirdGroup = listOf(getString(R.string.item_list_6))
        val fourthGroup = listOf(getString(R.string.item_list_7), getString(R.string.item_list_8))
        val fifthGroup = listOf(getString(R.string.item_list_9), getString(R.string.item_list_10), getString(R.string.item_list_11))
        materialsCollection[groupList[0]] = firstGroup
        materialsCollection[groupList[1]] = secondGroup
        materialsCollection[groupList[2]] = thirdGroup
        materialsCollection[groupList[3]] = fourthGroup
        materialsCollection[groupList[4]] = fifthGroup
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