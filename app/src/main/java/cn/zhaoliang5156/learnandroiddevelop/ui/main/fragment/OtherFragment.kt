package cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_other.*


/**
 * 其他
 * A simple [Fragment] subclass.
 */
class OtherFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_other, container, false)
    }

    // 列表项点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {

        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置布局管理器
        other_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // 初始化数据适配器
        val listAdapter = ListAdapter(context, resources.getStringArray(R.array.Other))
        // 设置列表项点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置数据适配器
        other_list.adapter = listAdapter
    }

}// Required empty public constructor
