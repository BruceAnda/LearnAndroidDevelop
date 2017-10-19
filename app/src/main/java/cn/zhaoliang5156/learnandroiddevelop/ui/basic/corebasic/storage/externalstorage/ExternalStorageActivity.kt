package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.storage.externalstorage

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_external_storage.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * 外部存储
 */
class ExternalStorageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)

        // 设置标题
        title = "外部存储"

        // 请求写内存卡的权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 10001)
        }
    }

    /**
     * 保存文件
     */
    fun save(view: View) {
        // 1. 判断sd卡是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 2. 获取输出流
            val fileOutputStream = FileOutputStream("${getExternalFilesDir(null)}${File.separator}${et_ex_filename.text}")
            // 3. 写入数据
            fileOutputStream.write(et_ex_filevalue.text.toString().toByteArray())
            // 4. 关闭流
            fileOutputStream.close()
            // 5. 提示
            Toast.makeText(this@ExternalStorageActivity, "保存成功！", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@ExternalStorageActivity, "SD卡没有挂载", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 读文件
     */
    fun read(view: View) {
        // 1. 判断sd卡是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 2. 获取输入流
            val fileInputStream = FileInputStream("${getExternalFilesDir(null)}${java.io.File.separator}${et_ex_filename.text}")
            // 3. 读取内容
            val outputStream = ByteArrayOutputStream()
            var b = ByteArray(1024)
            var len = fileInputStream.read(b)
            while (len != -1) {
                outputStream.write(b, 0, len)
                len = fileInputStream.read(b)
            }
            // 4. 显示内容
            et_ex_filevalue.setText(outputStream.toString())
            // 5. 关闭流
            outputStream.close()
            fileInputStream.close()
        } else {
            Toast.makeText(this@ExternalStorageActivity, "SD卡没有挂载", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 保存文件
     */
    fun save2(view: View) {
        // 1. 判断SD卡是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 2. 获取输出流
            val file = File("${Environment.getExternalStorageDirectory()}${File.separator}learnandroid")
            if (!file.exists()) {
                file.mkdirs()
            }
            val fileOutputStream = FileOutputStream(File("${Environment.getExternalStorageDirectory()}${File.separator}learnandroid", "${et_ex_filename.text}"))
            // 3. 写入数据
            fileOutputStream.write(et_ex_filevalue.text.toString().toByteArray())
            // 4. 关闭流
            fileOutputStream.close()
            // 提示
            Toast.makeText(this@ExternalStorageActivity, "写入成功！", Toast.LENGTH_SHORT).show()
        } else {
            // 提示
            Toast.makeText(this@ExternalStorageActivity, "SD卡没有挂载", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 读文件
     */
    fun read2(view: View) {
        // 1. 判断SD卡是否挂载
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            // 2. 获取输入流
            val fileInputStream = FileInputStream("${Environment.getExternalStorageDirectory()}${File.separator}learnandroid${File.separator}${et_ex_filename.text}")
            // 3. 读取内容
            val outputStream = ByteArrayOutputStream()
            var b = ByteArray(1024)
            var len = fileInputStream.read(b)
            while (len != -1) {
                outputStream.write(b, 0, len)
                len = fileInputStream.read(b)
            }
            // 4. 显示内容
            et_ex_filevalue.setText(outputStream.toString())
            // 5. 关闭流
            outputStream.close()
            fileInputStream.close()
        } else {
            Toast.makeText(this@ExternalStorageActivity, "SD卡没有挂载", Toast.LENGTH_SHORT).show()
        }
    }
}
