package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.applist.AppListActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.dialog.DialogActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.gridview.GridViewActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout.LayoutActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.ListViewActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.menu.MenuActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.progress.ProgressActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.simplecomponent.SimpleComponenetActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.styleandtheme.StyleAndThemeActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity
import kotlinx.android.synthetic.main.activity_ui.*

/**
 * 界面
 */
class UIActivity : BaseActivity() {

    // 要跳转到的目的地
    private val mTargets = arrayOf(
            SimpleComponenetActivity::class.java,
            MenuActivity::class.java,
            ProgressActivity::class.java,
            DialogActivity::class.java,
            LayoutActivity::class.java,
            ListViewActivity::class.java,
            StyleAndThemeActivity::class.java,
            AppListActivity::class.java,
            GridViewActivity::class.java
    )

    // 列表点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            startActivity(Intent(this@UIActivity, mTargets[position]))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // update title property
        title = "UI"

        // 设置内容布局
        setContentView(R.layout.activity_ui)
        // 设置布局管理器
        ui_list.layoutManager = LinearLayoutManager(this)
        // 初始化Adapter对象
        val listAdapter = ListAdapter(this, resources.getStringArray(R.array.UIMain))
        // 设置列表项点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置适配器
        ui_list.adapter = listAdapter
    }
}
