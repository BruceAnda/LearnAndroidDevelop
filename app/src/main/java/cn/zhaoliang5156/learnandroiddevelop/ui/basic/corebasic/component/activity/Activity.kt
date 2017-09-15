package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylifecycle.ActivityLifeCycleActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylunchmode.ActivityLunchModeActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.phoneandsms.PhoneAndSmsActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.useactivity.UseActivity
import kotlinx.android.synthetic.main.activity_.*

/**
 * 学习Activity
 * 内容：
 *      1. Activity的基本使用
 *      2. Activity的生命周期
 *      3. Activity的启动模式
 */
class Activity : AppCompatActivity() {

    // 目标页面
    private val mTarget = arrayOf(UseActivity::class.java,
            ActivityLifeCycleActivity::class.java,
            ActivityLunchModeActivity::class.java,
            PhoneAndSmsActivity::class.java
    )

    // 创建列表项点击事件对象
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            // 点击列表项的时候跳转到对应的页面
            startActivity(Intent(this@Activity, mTarget[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_)

        title = "Activity"

        // 设置列表的LayoutManager
        activity_list.layoutManager = LinearLayoutManager(this@Activity)
        // 初始化Adapter
        val adapter = ListAdapter(this@Activity, resources.getStringArray(R.array.Activity))
        // 设置列表项点击事件
        adapter.onListItemClickListener = mOnListItemClickListener
        // 设置适配器
        activity_list.adapter = adapter
    }
}
