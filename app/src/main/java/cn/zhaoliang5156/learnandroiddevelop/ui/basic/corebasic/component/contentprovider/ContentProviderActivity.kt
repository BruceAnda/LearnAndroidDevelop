package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.contentprovider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * ContentProvider
 */
class ContentProviderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        // 设置标题
        title = "内容提供者"
    }
}
