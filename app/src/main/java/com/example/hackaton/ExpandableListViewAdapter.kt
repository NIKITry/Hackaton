package com.example.hackaton

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableListViewAdapter internal constructor(private val context: Context,
                                                     private val chapterList: List<String>,
                                                     private val topicsList: HashMap<String, List<String>>) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return chapterList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.topicsList[this.chapterList[p0]]!!.size
    }

    override fun getGroup(p0: Int): Any {
        return chapterList[p0]
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return this.topicsList[this.chapterList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView = p2
        val chapterTitle = getGroup(p0) as String
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.group_item, null)
        }
        val chapterTv = convertView!!.findViewById<TextView>(R.id.groupMaterial)
        chapterTv.text = chapterTitle
        return convertView
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView = p3
        val topicTitle = getChild(p0, p1) as String
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.child_item, null)
        }
        val chapterTv = convertView!!.findViewById<TextView>(R.id.itemMaterial)
        chapterTv.text = topicTitle
        return convertView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }


}