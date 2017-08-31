package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.quickstart.demos.simpledownloadui

import android.os.Bundle
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity
import kotlinx.android.synthetic.main.activity_simple_download_ui.*

/**
 * SimpleDownloadUI
 */
class SimpleDownloadUIActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_download_ui)

        // 设置标题
        title = "SimpleDownloadUI"

        // 设置点击事件
        btn_download.setOnClickListener {
            // 弹出提示
            Toast.makeText(this@SimpleDownloadUIActivity, "下载中。。。", Toast.LENGTH_SHORT).show()
            // 修改Button的显示文字
            btn_download.text = "下载中。。。"
        }
    }
}
