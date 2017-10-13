package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.coremachine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 核心机制
 */
class CoreMachineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core_machine)

        // 修改标题属性
        title = "核心机制"
    }
}
