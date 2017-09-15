package cn.zhaoliang5156.learnandroiddevelop.ui.basic.advance

import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity

/**
 * 高级开发
 */
class AdvanceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance)

        // 设置标题
        title = "高级开发"
    }
}
