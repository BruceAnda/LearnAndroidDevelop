package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.applist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_app_list.*
import kotlinx.android.synthetic.main.app_list_item.view.*

/**
 * 应用程序列表
 */
class AppListActivity : AppCompatActivity() {

    private val appList = ArrayList<AppInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_list)

        // 设置标题
        title = "AppList"

        getAllAppInfos()

        val adapter = AppListAdapter()
        app_list.adapter = adapter

        app_list.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@AppListActivity, appList[position].appName, Toast.LENGTH_SHORT).show()
        }
        app_list.setOnItemLongClickListener { parent, view, position, id ->
            appList.remove(appList[position])
            adapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }
    }

    /**
     * 获取所有应用程序信息
     */
    private fun getAllAppInfos() {
        val intent = Intent()
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_LAUNCHER)
        val app = packageManager.queryIntentActivities(intent, 0)
        app.mapTo(appList) { AppInfo(it.loadIcon(packageManager), it.loadLabel(packageManager) as String, it.activityInfo.packageName) }
    }

    private val TAG = AppListActivity::class.java.simpleName

    /**
     * 数据适配器
     */
    inner class AppListAdapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            return (convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.app_list_item, parent, false).apply {
                tag = ViewHolder(this)
                Log.i(TAG, "new")
            }).apply {
                Log.i(TAG, "old")
                (tag as ViewHolder).apply {
                    bind(appList[position])
                    Log.i(TAG, "填充数据")
                }
            }
        }

        override fun getItem(position: Int): Any {
            return appList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return appList.size
        }

        inner class ViewHolder(var itemView: View) {
            fun bind(appInfo: AppInfo) {
                itemView.iv_app_item_icon.setImageDrawable(appInfo.icon)
                itemView.tv_item_name.text = appInfo.appName
            }
        }
    }
}
