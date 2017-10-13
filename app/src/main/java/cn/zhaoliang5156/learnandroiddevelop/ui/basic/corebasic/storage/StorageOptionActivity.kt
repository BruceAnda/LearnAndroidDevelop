package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 数据存储
 */
class StorageOptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_option)

        // update title property
        title = "数据存储"
    }
}
