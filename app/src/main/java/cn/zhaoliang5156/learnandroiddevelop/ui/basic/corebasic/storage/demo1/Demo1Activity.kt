package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.demo1

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.gridview.Menu
import kotlinx.android.synthetic.main.activity_demo1.*
import kotlinx.android.synthetic.main.gv_item.view.*

/**
 * SharedPreferences的使用
 */
class Demo1Activity : AppCompatActivity() {

    private var mData = ArrayList<Menu>()

    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo1)

        // 设置标题
        title = "数据存储上demo"

        mSharedPreferences = getSharedPreferences("menu", Context.MODE_PRIVATE)

        mData.add(Menu(R.drawable.widget01, "手机防盗"))
        mData.add(Menu(R.drawable.widget02, "通讯卫士"))
        mData.add(Menu(R.drawable.widget03, "软件管理"))
        mData.add(Menu(R.drawable.widget04, "流量管理"))
        mData.add(Menu(R.drawable.widget05, "进程管理"))
        mData.add(Menu(R.drawable.widget06, "手机杀毒"))
        mData.add(Menu(R.drawable.widget07, "缓存清理"))
        mData.add(Menu(R.drawable.widget08, "高级工具"))
        mData.add(Menu(R.drawable.widget09, "设置中心"))

        val adapter = GridAdapter()
        gv_main.adapter = adapter

        /**
         * 点击事件
         */
        gv_main.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@Demo1Activity, mData[position].name, Toast.LENGTH_SHORT).show()
        }

        gv_main.setOnItemLongClickListener { parent, view, position, id ->
            if (position == 0) {
                val name = mData[position].name
                val editText = EditText(this@Demo1Activity)
                editText.hint = name
                AlertDialog.Builder(this@Demo1Activity)
                        .setTitle("修改名称")
                        .setView(editText)
                        .setPositiveButton("修改") { dialog, which ->
                            val menuName = editText.text.toString()
                            mData[position].name = menuName
                            mSharedPreferences.edit().putString("menu", menuName).commit()
                            adapter.notifyDataSetChanged()
                        }
                        .setNegativeButton("取消", null)
                        .show()
            }
            return@setOnItemLongClickListener true
        }
    }

    inner class GridAdapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            return (convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.gv_item, parent, false).apply {
                tag = ViewHolder(this)
            }).apply {
                (tag as ViewHolder).apply {
                    val item = mData[position]
                    if (position == 0) {
                        val menu = mSharedPreferences.getString("menu", "")
                        if (!TextUtils.isEmpty(menu)) {
                            item.name = menu
                        }
                    }
                    bind(item)
                }
            }
        }

        override fun getItem(position: Int): Any {
            return mData[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return mData.size
        }

        inner class ViewHolder(var itemView: View) {
            fun bind(menu: Menu) {
                itemView.iv_item_icon.setImageResource(menu.icon)
                itemView.tv_item_name.text = menu.name
            }
        }
    }
}
