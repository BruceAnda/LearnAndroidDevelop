package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.ComponentActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.Activity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.coremachine.CoreMachineActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.fragment.FragmentActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.media.MediaActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.QuickstartActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.StorageOptionActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.UIActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity
import kotlinx.android.synthetic.main.activity_core_basic.*

/**
 * 核心基础页面
 */
class CoreBasicActivity : BaseActivity() {

    // 核心基础目标页面
    private val mTarget = arrayOf(
            QuickstartActivity::class.java,
            ComponentActivity::class.java,
            UIActivity::class.java,
            StorageOptionActivity::class.java,
            CoreMachineActivity::class.java,
            MediaActivity::class.java,
            FragmentActivity::class.java
    )

    /**
     * 核心基础点击事件
     */
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            startActivity(Intent(this@CoreBasicActivity, mTarget[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core_basic)

        // 设置标题
        title = "核心基础"

        core_basic_list.layoutManager = LinearLayoutManager(this@CoreBasicActivity, LinearLayoutManager.VERTICAL, false)
        val listAdapter = ListAdapter(this@CoreBasicActivity, resources.getStringArray(R.array.CoreBasic))
        listAdapter.onListItemClickListener = mOnListItemClickListener
        core_basic_list.adapter = listAdapter
    }
}
