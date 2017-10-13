package cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.common.extensions.inflate
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.advance.AdvanceActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.CoreBasicActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_basic.*


/**
 * 核心基础
 * A simple [Fragment] subclass.
 */
class BasicFragment : BaseFragment() {

    /**
     * 当创建view的时候调用
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return container?.inflate(R.layout.fragment_basic)
    }

    // 要跳转的目的地
    private val mTarget = arrayOf(
            CoreBasicActivity::class.java,
            AdvanceActivity::class.java
    )

    // 列表项点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            // 页面跳转
            startActivity(Intent(context, mTarget[position]))
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 设置布局管理器
        basic_list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // 初始化数据适配器
        val listAdapter = ListAdapter(context, resources.getStringArray(R.array.Basic))
        // 设置列表项点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置数据适配器
        basic_list.adapter = listAdapter
    }

}// Required empty public constructor
