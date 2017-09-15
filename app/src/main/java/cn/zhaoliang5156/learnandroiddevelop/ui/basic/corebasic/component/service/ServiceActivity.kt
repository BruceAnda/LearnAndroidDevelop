package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.service

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * Service
 */
class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        // 设置标题
        title = "Service"
    }
}
