package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.ui.menu

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_menu.*

/**
 * 学习Menu的使用
 */
class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // 设置ContentMenu事件
        btn_content_menu.setOnCreateContextMenuListener(this)
    }

    /**
     * 当选项菜单创建的时候调用
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * 当选项菜单选择的时候调用
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.navigation_base -> {
                Toast.makeText(this@MenuActivity, "基础", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_other -> {
                Toast.makeText(this@MenuActivity, "其他", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_proj -> {
                Toast.makeText(this@MenuActivity, "项目", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_third -> {
                Toast.makeText(this@MenuActivity, "三方", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 当上下文菜单创建的时候调用
     */
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.navigation, menu)
    }

    /**
     * 当上下文菜单选择的时候调用
     */
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.navigation_base -> {
                Toast.makeText(this@MenuActivity, "基础", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_other -> {
                Toast.makeText(this@MenuActivity, "其他", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_proj -> {
                Toast.makeText(this@MenuActivity, "项目", Toast.LENGTH_SHORT).show()
            }
            R.id.navigation_third -> {
                Toast.makeText(this@MenuActivity, "三方", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }
}
