package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.dialog

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.dialog_view.view.*
import java.util.*

/**
 * 对话框
 */
class DialogActivity : AppCompatActivity() {

    private val TAG = DialogActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置内容布局
        setContentView(R.layout.activity_dialog)
    }

    /**
     * 显示一般的对话框
     */
    fun showAD(view: View) {
        AlertDialog.Builder(this)
                .setTitle("删除数据")
                .setMessage("你确定删除数据吗？")
                .setPositiveButton("删除", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this@DialogActivity, "删除数据", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("取消", DialogInterface.OnClickListener { dialogInterface, i ->
                    Toast.makeText(this@DialogActivity, "取消删除数据", Toast.LENGTH_SHORT).show()
                })
                .show()
    }

    /**
     * 显示列表的对话框
     */
    fun showLD(view: View) {
        val arrayOf = arrayOf("红", "绿", "蓝", "灰")
        AlertDialog.Builder(this)
                .setTitle("指定背景颜色")
                .setSingleChoiceItems(arrayOf, 2, object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface, p1: Int) {
                        // 1. 提示颜色
                        Toast.makeText(this@DialogActivity, arrayOf[p1], Toast.LENGTH_SHORT).show()
                        // 2. 移除对话框
                        p0.dismiss()
                    }
                })
                .show()
    }

    /**
     * 显示自定义的对话框
     */
    fun showCD(view: View) {
        // 加载布局
        val view1 = LayoutInflater.from(this).inflate(R.layout.dialog_view, null)
        AlertDialog.Builder(this)
                .setView(view1)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        // 提示
                        Toast.makeText(this@DialogActivity, "${view1.et_dialog_name.text} : ${view1.et_dialog_pwd.text}", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
    }

    /**
     * 显示圆形进度对话框
     */
    fun showPD(view: View) {
        val progressDialog = ProgressDialog.show(this, "数据加载", "数据加载中...")
        object : Thread() {
            override fun run() {
                // 模拟服务器卡
                for (i in 1..20) {
                    // 线程休眠
                    Thread.sleep(100)
                }
                progressDialog.dismiss()
            }
        }.start()
    }

    /**
     * 显示水平进度对话框
     */
    fun showPD2(view: View) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        progressDialog.show()
        progressDialog.max = 20
        object : Thread() {
            override fun run() {
                for (i in 1..20) {
                    Thread.sleep(100)
                    progressDialog.progress = progressDialog.progress + 1
                }
                progressDialog.dismiss()
            }
        }.start()
    }

    /**
     * 显示日期对话框
     */
    fun showDD(view: View) {
        // 获取日历对象
        val calendar = Calendar.getInstance()
        // 获取年
        val year = calendar.get(Calendar.YEAR)
        // 获取月
        val month = calendar.get(Calendar.MONTH)
        // 获取日
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { p0, p1, p2, p3 -> Log.i(TAG, "$p1-${p2 + 1}-$p3") }, year, month, day).show()
    }

    /**
     * 显示时间对话框
     */
    fun showTD(view: View) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 -> Log.i(TAG, "$i:$i2") }, hour, minute, true).show()
    }
}
