package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.Activity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.broadcastreceiver.BroadcastReceiverActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.contentprovider.ContentProviderActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.service.ServiceActivity
import kotlinx.android.synthetic.main.activity_component.*

/**
 * 四大组件
 */
class ComponentActivity : AppCompatActivity() {

    // 目标页面
    private val mTarget = arrayOf(Activity::class.java,
            ServiceActivity::class.java,
            BroadcastReceiverActivity::class.java,
            ContentProviderActivity::class.java
    )

    // 列表项点击事件对象
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            startActivity(Intent(this@ComponentActivity, mTarget[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 设置标题
        title = "四大组件"

        // 设置内容布局
        setContentView(R.layout.activity_component)

        // 设置LayoutManager
        component_list.layoutManager = LinearLayoutManager(this@ComponentActivity)
        // 初始化适配器
        val listAdapter = ListAdapter(this@ComponentActivity, resources.getStringArray(R.array.Component))
        // 设置列表项点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置Adapter
        component_list.adapter = listAdapter
    }
}
