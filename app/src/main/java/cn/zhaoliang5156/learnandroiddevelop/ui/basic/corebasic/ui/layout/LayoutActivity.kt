package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout.layout.FrameLayoutActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout.layout.LinearLayoutActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout.layout.RelativeLayoutActivity
import kotlinx.android.synthetic.main.activity_layout.*

/**
 * 布局
 */
class LayoutActivity : AppCompatActivity() {

    // 目标界面
    private val mTarget = arrayOf(
            LinearLayoutActivity::class.java,
            RelativeLayoutActivity::class.java,
            FrameLayoutActivity::class.java
    )

    // 列表点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            // 界面跳转
            startActivity(Intent(this@LayoutActivity, mTarget[position]))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        // 设置标题属性
        title = "Layout"

        // 设置布局管理器
        layout_list.layoutManager = LinearLayoutManager(this@LayoutActivity)

        // 初始化适配器
        val listAdapter = ListAdapter(this, resources.getStringArray(R.array.Layout))
        // 设置点击事件属性
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置适配器属性
        layout_list.adapter = listAdapter
    }
}
