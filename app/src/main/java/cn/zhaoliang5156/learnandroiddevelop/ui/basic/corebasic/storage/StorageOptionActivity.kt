package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.ListAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.demo1.Demo1Activity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.externalstorage.ExternalStorageActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.internalstorage.InternalStorageActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.sharedperferences.SharedPreferencesActivity
import kotlinx.android.synthetic.main.activity_storage_option.*

/**
 * 数据存储
 */
class StorageOptionActivity : AppCompatActivity() {

    // 要跳转到的目的地
    private val mTarget = arrayOf(
            SharedPreferencesActivity::class.java,
            InternalStorageActivity::class.java,
            ExternalStorageActivity::class.java,
            Demo1Activity::class.java
    )

    // 列表点击事件
    private val mOnListItemClickListener = object : ListAdapter.OnListItemClickListener {
        override fun onListItemClick(view: View, position: Int) {
            startActivity(Intent(this@StorageOptionActivity, mTarget[position]))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_option)

        // update title property
        title = "数据存储"

        // 设置布局管理器
        storage_optioin_list.layoutManager = LinearLayoutManager(this)
        // 创建Adapter
        val listAdapter = ListAdapter(this, resources.getStringArray(R.array.StorageOption))
        // 设置点击事件
        listAdapter.onListItemClickListener = mOnListItemClickListener
        // 设置适配器
        storage_optioin_list.adapter = listAdapter
    }
}
