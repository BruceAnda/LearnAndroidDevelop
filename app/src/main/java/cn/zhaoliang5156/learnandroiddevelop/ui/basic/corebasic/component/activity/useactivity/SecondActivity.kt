package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.useactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_second.*

/**
 * SecondActivity
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 设置标题
        title = "第二个界面"

        intent.extras?.let {
            et_message_second.setText(intent.extras.getString("message"))
        }
    }

    /**
     * 一般的返回
     */
    fun back(view: View) {
        finish()
    }

    /**
     * 带结果的返回
     */
    fun back2(view: View) {
        val intent = Intent()
        intent.putExtra("result", et_message_second.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
