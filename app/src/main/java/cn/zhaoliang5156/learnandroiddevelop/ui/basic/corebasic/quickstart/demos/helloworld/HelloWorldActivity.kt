package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.demos.helloworld

import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity

/**
 * 需求：在手机屏幕上显示HelloWorld的字样
 */
class HelloWorldActivity : BaseActivity() {

    /**
     * 当Activity创建的时候有系统调用这个方法
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 设置在手机屏幕上显示的界面
        setContentView(R.layout.activity_hello_world)

        // 设置标题
        title = "HelloWorld"
    }
}
