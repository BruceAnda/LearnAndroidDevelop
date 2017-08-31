package cn.zhaoliang5156.learnandroiddevelop.ui.main.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import cn.zhaoliang5156.learnandroiddevelop.R
import cn.zhaoliang5156.learnandroiddevelop.adapter.MainPagerAdapter
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseActivity
import cn.zhaoliang5156.learnandroiddevelop.ui.main.base.BaseFragment
import cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment.BasicFragment
import cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment.OtherFragment
import cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment.ProjFragment
import cn.zhaoliang5156.learnandroiddevelop.ui.main.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 程序的主界面
 */
class MainActivity : BaseActivity() {

    // 底部导航的id
    private val mNavigationIds = arrayOf(R.id.navigation_base, R.id.navigation_third, R.id.navigation_proj, R.id.navigation_other)

    // 底部导航选择事件监听
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            mNavigationIds[0] -> {
                changePager(0)
                // 设置标题
                title = getString(R.string.title_base)
                return@OnNavigationItemSelectedListener true
            }
            mNavigationIds[1] -> {
                changePager(1)
                title = getString(R.string.title_third)
                return@OnNavigationItemSelectedListener true
            }
            mNavigationIds[2] -> {
                changePager(2)
                title = getString(R.string.title_proj)
                return@OnNavigationItemSelectedListener true
            }
            mNavigationIds[3] -> {
                changePager(3)
                title = getString(R.string.title_other)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * 改变页面
     * @param page 页面
     */
    private fun changePager(page: Int) {
        pagers.currentItem = page
    }

    // 页面改变事件监听
    private val mOnPagerChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            changeNavigation(position)
        }
    }

    /**
     * 改变导航
     */
    private fun changeNavigation(position: Int) {
        navigation.selectedItemId = mNavigationIds[position]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置内容布局
        setContentView(R.layout.activity_main)

        // 设置标题
        title = getString(R.string.title_base)

        // 数据集
        val datas = ArrayList<BaseFragment>()
        datas.add(BasicFragment())
        datas.add(ThirdFragment())
        datas.add(ProjFragment())
        datas.add(OtherFragment())
        pagers.adapter = MainPagerAdapter(supportFragmentManager, datas)

        // 设置页面改变事件监听
        pagers.addOnPageChangeListener(mOnPagerChangeListener)

        // 设置导航选择监听
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
