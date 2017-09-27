package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.progress

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_progress.*

/**
 * Progress
 */
class ProgressActivity : AppCompatActivity() {

    private val TAG = ProgressActivity::class.java.simpleName

    // 滑杆滑动事件监听
    private val mOnSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            Log.i(TAG, "滑动滑杆")
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {
            Log.i(TAG, "按下滑杆")
        }

        override fun onStopTrackingTouch(p0: SeekBar) {
            Log.i(TAG, "离开滑杆")
            // 1. 获取滑杆的进度
            val progress = p0.progress
            // 2. 设置ProgressBar的进度
            pb_progress_loading.progress = progress
            // 3. 判断进度是否达到最大，最大隐藏最上边的进度，没有达到就显示
            if (progress == sb_progress_lading.max) {
                ll_progress_loading.visibility = View.GONE
            } else {
                ll_progress_loading.visibility = View.VISIBLE
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        // 设置seekBar滑动事件
        sb_progress_lading.setOnSeekBarChangeListener(mOnSeekBarChangeListener)
    }
}
