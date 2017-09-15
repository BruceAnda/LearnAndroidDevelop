package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.useactivity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_use.*

/**
 * Activity的基本使用
 */
class UseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use)

        // 设置标题
        title = "Activity的基本使用"
    }

    /**
     * 一般的启动
     */
    fun start(view: View) {
        val intent = Intent(this@UseActivity, SecondActivity::class.java)
        intent.putExtra("message", et_message_main.text.toString())
        startActivity(intent)
    }

    private val MAIN_REQUST_CODE = 1000

    /**
     * 带结果的启动
     */
    fun start2(view: View) {
        val intent = Intent(this@UseActivity, SecondActivity::class.java)
        intent.putExtra("message", et_message_main.text.toString())
        startActivityForResult(intent, MAIN_REQUST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MAIN_REQUST_CODE && resultCode == Activity.RESULT_OK) {
            // 设置结果
            data?.extras?.let {
                et_message_main.setText(data.extras.getString("result"))
            }
        }
    }
}
