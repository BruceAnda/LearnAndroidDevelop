package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.internalstorage

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_internal_storage.*
import java.io.File

/**
 * 内部存储
 */
class InternalStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)

        // 设置标题
        title = "内部存储"
    }

    /**
     * 保存
     */
    fun save(view: View) {
        // 1. 获取assert目录下的文件
        val inputStream = assets.open("logo.png")
        // 2. 创建输出流
        val fileOutput = openFileOutput("logo.png", Context.MODE_PRIVATE)
        // 3. 写文件
        var b = ByteArray(1024)
        var len = inputStream.read(b)
        while (len != -1) {
            fileOutput.write(b, 0, len)
            len = inputStream.read(b)
        }
        fileOutput.close()
        inputStream.close()
        // 4. 提示
        Toast.makeText(this@InternalStorageActivity, "写入成功！", Toast.LENGTH_SHORT).show()
    }

    /**
     * 读取
     */
    fun read(view: View) {
        // 显示图片
        iv_image.setImageBitmap(BitmapFactory.decodeFile("$filesDir${File.separator}logo.png"))
    }
}
