package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylunchmode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 第二个界面
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second3)
    }

    /**
     * 跳转到界面三
     */
    fun startThird(view: View) {
        startActivity(Intent(this@SecondActivity, ThirdActivity::class.java))
    }

    /**
     * 跳转到界面一
     */
    fun startFirst(view: View) {
        startActivity(Intent(this@SecondActivity, ActivityLunchModeActivity::class.java))
    }
}
