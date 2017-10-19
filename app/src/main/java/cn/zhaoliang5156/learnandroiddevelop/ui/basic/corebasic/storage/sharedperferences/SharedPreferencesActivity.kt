package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.sharedperferences

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_shared_perferences.*

/**
 * 使用SharedPerferences存储数据
 */
class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var sharePerferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_perferences)

        // 设置标题
        title = "SharedPerferences"

        sharePerferences = getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

    /**
     * 保存数据
     */
    fun save(view: View) {
        // 1. 得到键和值
        val key = et_sp_key.text.toString()
        val value = et_sp_value.text.toString()
        // 2. 编辑sp
        sharePerferences.edit().putString(key, value).commit()
        // 3. 提示
        Toast.makeText(this, "保存完成", Toast.LENGTH_SHORT).show()
    }

    /**
     * 读取数据
     */
    fun read(view: View) {
        // 1. 拿到键
        val key = et_sp_key.text.toString()
        // 2. 查找value
        val value = sharePerferences.getString(key, null)
        // 3. 显示
        if (value == null) {
            Toast.makeText(this@SharedPreferencesActivity, "没有找到对应的value", Toast.LENGTH_SHORT).show()
        } else {
            et_sp_value.setText(value)
        }
    }
}
