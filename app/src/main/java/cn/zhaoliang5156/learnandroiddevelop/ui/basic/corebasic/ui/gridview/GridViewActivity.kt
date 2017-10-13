package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.gridview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_grid_view.*
import kotlinx.android.synthetic.main.gv_item.view.*

/**
 * GridView
 */
class GridViewActivity : AppCompatActivity() {

    private var mData = ArrayList<Menu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        // 设置标题
        title = "GridView"

        mData.add(Menu(R.drawable.widget01, "手机防盗"))
        mData.add(Menu(R.drawable.widget02, "通讯卫士"))
        mData.add(Menu(R.drawable.widget03, "软件管理"))
        mData.add(Menu(R.drawable.widget04, "流量管理"))
        mData.add(Menu(R.drawable.widget05, "进程管理"))
        mData.add(Menu(R.drawable.widget06, "手机杀毒"))
        mData.add(Menu(R.drawable.widget07, "缓存清理"))
        mData.add(Menu(R.drawable.widget08, "高级工具"))
        mData.add(Menu(R.drawable.widget09, "设置中心"))

        gv_main.adapter = Adapter()

        /**
         * 点击事件
         */
        gv_main.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this@GridViewActivity, mData[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 数据适配器
     */
    inner class Adapter : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            return (convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.gv_item, parent, false).apply {
                tag = ViewHolder(this)
            }).apply {
                (tag as ViewHolder).apply {
                    bind(mData[position])
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
