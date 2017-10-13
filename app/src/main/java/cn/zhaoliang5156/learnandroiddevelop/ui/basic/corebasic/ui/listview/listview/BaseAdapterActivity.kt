package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.common.extensions.inflate
import kotlinx.android.synthetic.main.activity_base_adapter.*
import kotlinx.android.synthetic.main.list_view_item.view.*

/**
 * BaseAdapter
 */
class BaseAdapterActivity : AppCompatActivity() {

    private val mData = ArrayList<ShopInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_adapter)

        mData.add(ShopInfo(R.drawable.f1, "title-1", "content-1"))
        mData.add(ShopInfo(R.drawable.f2, "title-2", "content-2"))
        mData.add(ShopInfo(R.drawable.f3, "title-3", "content-3"))
        mData.add(ShopInfo(R.drawable.f4, "title-4", "content-4"))
        mData.add(ShopInfo(R.drawable.f5, "title-5", "content-5"))
        mData.add(ShopInfo(R.drawable.f6, "title-6", "content-6"))
        mData.add(ShopInfo(R.drawable.f7, "title-7", "content-7"))
        mData.add(ShopInfo(R.drawable.f8, "title-8", "content-8"))
        mData.add(ShopInfo(R.drawable.f9, "title-9", "content-9"))
        mData.add(ShopInfo(R.drawable.f10, "title-10", "content-10"))

        baseadapter_list.adapter = Adapter()
    }

    inner class Adapter : BaseAdapter() {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            return (convertView?:LayoutInflater.from(parent.context).inflate(R.layout.list_view_item, parent, false).apply {
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
            return position as Long
        }

        override fun getCount(): Int {
            return mData.size
        }

        inner class ViewHolder(var itemView: View) {
            fun bind(shopInfo: ShopInfo) {
                itemView.lv_item_icon.setImageResource(shopInfo.icon)
                itemView.tv_item_title.text = shopInfo.title
                itemView.tv_item_content.text = shopInfo.content
            }
        }
    }

    class ShopInfo(
            var icon: Int,
            var title: String,
            var content: String
    )
}
