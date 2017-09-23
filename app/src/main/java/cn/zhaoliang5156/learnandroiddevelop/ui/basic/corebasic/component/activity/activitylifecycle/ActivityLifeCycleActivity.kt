package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.activitylifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import cn.zhaoliang5156.learnandroiddevelop.R

/**
 * Activity的生命周期
 * 死亡-》运行
 * onCreate()->onStart()->onResume()
 * 运行-》死亡
 * onPause()->onStop->onDestroy()
 * 运行-》停止
 * onPause()->onStop()
 * 停止-》运行
 * onRestart()->onStart()->onResume()
 * 运行-》暂停
 * onPause()
 * 暂停-》运行
 * onResume()
 */
class ActivityLifeCycleActivity : AppCompatActivity {

    private val TAG = ActivityLifeCycleActivity::class.java.simpleName

    constructor() : super() {
        Log.i(TAG, "ActivityLifeCycle")
    }

    fun start(view: View) {
        startActivity(Intent(this@ActivityLifeCycleActivity, SecondActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.i(TAG, "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy()")
    }
}
