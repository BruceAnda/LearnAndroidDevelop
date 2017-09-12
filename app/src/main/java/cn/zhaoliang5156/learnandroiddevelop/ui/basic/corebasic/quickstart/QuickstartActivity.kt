package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.demos.helloworld.HelloWorldActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.demos.simpledownloadui.SimpleDownloadUIActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity
import kotlinx.android.synthetic.main.activity_quickstart.*

/**
 * 需求：快速入门
 */
class QuickstartActivity : BaseActivity() {

    // 要跳转的目的地
    private val mTarget = arrayOf(
            HelloWorldActivity::class.java,
            SimpleDownloadUIActivity::class.java
    )

    // 列表项点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            // 页面跳转
            startActivity(Intent(this@QuickstartActivity, mTarget[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quickstart)

        // 设置标题
        title = "快速入门"

        // 设置布局管理器
        quick_start_list.layoutManager = LinearLayoutManager(this@QuickstartActivity, LinearLayoutManager.VERTICAL, false)
        // 初始化适配器
        val listAdapter = ListAdapter(this@QuickstartActivity, resources.getStringArray(R.array.QuickStart))
        // 设置列表项点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置数据适配器
        quick_start_list.adapter = listAdapter
    }
}
