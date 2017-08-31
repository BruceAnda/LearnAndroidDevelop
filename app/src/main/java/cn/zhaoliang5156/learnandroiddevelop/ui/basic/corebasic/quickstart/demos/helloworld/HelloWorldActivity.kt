package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.demos.helloworld

import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity

/**
 * HelloWorld
 */
class HelloWorldActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)

        // 设置标题
        title = "HelloWorld"
    }
}
