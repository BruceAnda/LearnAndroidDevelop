package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)
    }
}