package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.media

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 多媒体
 */
class MediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        // update title property
        title = "多媒体"
    }
}
