package cn.zhaoliang5156.learnandroiddevelop.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.simple_list_item.view.*

/**
 * 列表适配器
 * Created by zhaoliang on 2017/8/31.
 */
class ListAdapter(var context: Context, var datas: Array<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(datas[position])
        holder?.itemView?.setOnClickListener {
            onListItemClickListener?.onListItemClick(holder.itemView, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.simple_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: String) {
            itemView.tv_list_item_content.text = data
        }
    }

    lateinit var onListItemClickListener: OnListItemClickListener

    /**
     * 列表项点击事件
     */
    interface OnListItemClickListener {
        fun onListItemClick(view: View, position: Int)
    }
}