package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.listview.listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_array_adapter.*

/**
 * ArrayAdapter
 */
class ArrayAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_adapter)

        // 设置标题
        title = "ArrayAdapter"

        val data = arrayOf(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N"
        )
        array_adapter.adapter = ArrayAdapter<String>(this@ArrayAdapterActivity, android.R.layout.simple_list_item_1, data)
    }
}
