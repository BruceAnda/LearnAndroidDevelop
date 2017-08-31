package cn.zhaoliang5156.learnandroiddevelop.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseFragment

/**
 * 主页面适配器
 * Created by zhaoliang on 2017/8/29.
 */
class MainPagerAdapter(fm: FragmentManager?, var datas: ArrayList<BaseFragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return datas[position]
    }

    override fun getCount(): Int {
        return datas.size
    }
}