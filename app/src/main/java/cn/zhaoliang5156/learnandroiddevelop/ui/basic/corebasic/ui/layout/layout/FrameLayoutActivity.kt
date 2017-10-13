package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.layout.layout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 帧布局
 */
class FrameLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)

        // 设置标题
        title = "FrameLayout"
    }
}
