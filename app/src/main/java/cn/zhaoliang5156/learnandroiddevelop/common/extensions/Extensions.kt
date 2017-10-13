package cn.zhaoliang5156.learnandroiddevelop.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 在ViewGroup上扩展一个填充布局的方法
 * 这是kotlin特有的语法
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}