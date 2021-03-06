package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylunchmode

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * Activity的启动模式
 */
class ActivityLunchModeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch_mode)
    }

    /**
     * 跳转到第二个界面
     */
    fun startSecond(view: View) {
        startActivity(Intent(this@ActivityLunchModeActivity, SecondActivity::class.java))
    }

    /**
     * 跳转到第一个界面
     */
    fun startFirst(view: View) {
        startActivity(Intent(this@ActivityLunchModeActivity, ActivityLunchModeActivity::class.java))
    }
}
