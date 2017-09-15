package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.broadcastreceiver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * BroadcastReceiver
 */
class BroadcastReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        // 设置标题
        title = "广播"
    }
}
