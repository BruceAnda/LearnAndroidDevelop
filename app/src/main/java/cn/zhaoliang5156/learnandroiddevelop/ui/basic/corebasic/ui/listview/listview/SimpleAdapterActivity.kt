package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_simple_adapter.*
import kotlin.collections.ArrayList

/**
 * SimpleAdapter
 */
class SimpleAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_adapter)

        // 设置标题
        title = "SimpleAdapter"

        val data = ArrayList<Map<String, Any>>()
        val data1 = HashMap<String, Any>()
        data1.put("icon", R.drawable.f1)
        data1.put("title", "title-1")
        data1.put("content", "content-1")
        val data2 = HashMap<String, Any>()
        data2.put("icon", R.drawable.f2)
        data2.put("title", "title-2")
        data2.put("content", "content-2")
        val data3 = HashMap<String, Any>()
        data3.put("icon", R.drawable.f3)
        data3.put("title", "title-3")
        data3.put("content", "content-3")
        val data4 = HashMap<String, Any>()
        data4.put("icon", R.drawable.f4)
        data4.put("title", "title-4")
        data4.put("content", "content-4")
        val data5 = HashMap<String, Any>()
        data5.put("icon", R.drawable.f5)
        data5.put("title", "title-5")
        data5.put("content", "content-5")
        val data6 = HashMap<String, Any>()
        data6.put("icon", R.drawable.f6)
        data6.put("title", "title-6")
        data6.put("content", "content-6")
        val data7 = HashMap<String, Any>()
        data7.put("icon", R.drawable.f7)
        data7.put("title", "title-7")
        data7.put("content", "content-7")
        val data8 = HashMap<String, Any>()
        data8.put("icon", R.drawable.f8)
        data8.put("title", "title-8")
        data8.put("content", "content-8")
        val data9 = HashMap<String, Any>()
        data9.put("icon", R.drawable.f9)
        data9.put("title", "title-9")
        data9.put("content", "content-9")
        val data10 = HashMap<String, Any>()
        data10.put("icon", R.drawable.f10)
        data10.put("title", "title-10")
        data10.put("content", "content-10")

        data.add(data1)
        data.add(data2)
        data.add(data3)
        data.add(data4)
        data.add(data5)
        data.add(data6)
        data.add(data7)
        data.add(data8)
        data.add(data9)
        data.add(data10)

        val from = arrayOf("icon", "title", "content")
        var to = IntArray(3)
        to[0] = R.id.lv_item_icon
        to[1] = R.id.tv_item_title
        to[2] = R.id.tv_item_content
        simple_adapter_list.adapter = SimpleAdapter(this@SimpleAdapterActivity, data, R.layout.list_view_item, from, to)
    }
}
