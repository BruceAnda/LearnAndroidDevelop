package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.styleandtheme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * 样式和主题
 */
class StyleAndThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_style_and_theme)

        // 设置标题
        title = "StyleAndTheme"
    }
}
