package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview.ArrayAdapterActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview.BaseAdapterActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview.SimpleAdapterActivity
import kotlinx.android.synthetic.main.activity_list_view.*

/**
 * ListView
 */
class ListViewActivity : AppCompatActivity() {

    private val mTarget = arrayOf(
            ArrayAdapterActivity::class.java,
            SimpleAdapterActivity::class.java,
            BaseAdapterActivity::class.java
    )

    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            startActivity(Intent(this@ListViewActivity, mTarget[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // 设置标题
        title = "ListView"

        // 设置布局管理器
        listview_list.layoutManager = LinearLayoutManager(this@ListViewActivity)
        // 创建数据适配器
        val adapter = ListAdapter(this@ListViewActivity, resources.getStringArray(R.array.ListView))
        // 设置点击事件
        adapter.onListItemClickListener = mOnListItemClickListener

        // 设置数据适配器属性
        listview_list.adapter = adapter
    }
}
