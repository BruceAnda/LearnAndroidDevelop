package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.simplecomponent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_simple_componenet.*

/**
 * 简单的view
 * 1. TextView
 * 2. EditText
 * 3. Button
 * 4. ImageView
 * 5. CheckBox
 * 6. RadioButton + RadioGroup
 */
class SimpleComponenetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_componenet)

        // 修改TextView的文本
        tv_simple_message.text = "NB"

        // 提交按钮点击
        btn_simple_submit.setOnClickListener {
            // 提示
            Toast.makeText(this@SimpleComponenetActivity, et_simple_number.text.toString(), Toast.LENGTH_SHORT).show()
        }

        // 是否播放的标识
        var isPlay = false
        // 图片
        iv_simple_icon.setOnClickListener {
            isPlay = !isPlay
            // 设置背景和前景
            if (isPlay) {
                iv_simple_icon.setBackgroundResource(android.R.drawable.alert_light_frame)
                iv_simple_icon.setImageResource(android.R.drawable.ic_media_pause)
            } else {
                iv_simple_icon.setBackgroundResource(android.R.drawable.alert_dark_frame)
                iv_simple_icon.setImageResource(android.R.drawable.ic_media_play)
            }
        }

        // CheckBox
        cb_simple_foot.setOnCheckedChangeListener { _, b ->
            if (b) {
                Toast.makeText(this@SimpleComponenetActivity, "选中了足球", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SimpleComponenetActivity, "未选中足球", Toast.LENGTH_SHORT).show()
            }
        }

        // RadioGroup
        rg_simple_sex.setOnCheckedChangeListener { _, i ->
            Toast.makeText(this@SimpleComponenetActivity, "选中的性别是：" + findViewById<RadioButton>(i).text.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 确定按钮点击
     */
    fun confirm(view: View) {
        val buffer = StringBuffer()
        if (cb_simple_basket.isChecked) {
            buffer.append(cb_simple_basket.text.toString() + " ")
        }
        if (cb_simple_foot.isChecked) {
            buffer.append(cb_simple_foot.text.toString() + " ")
        }
        if (cb_simple_pingpang.isChecked) {
            buffer.append(cb_simple_pingpang.text.toString() + " ")
        }

        // 提示
        Toast.makeText(this@SimpleComponenetActivity, buffer.toString(), Toast.LENGTH_SHORT).show()
    }
}
