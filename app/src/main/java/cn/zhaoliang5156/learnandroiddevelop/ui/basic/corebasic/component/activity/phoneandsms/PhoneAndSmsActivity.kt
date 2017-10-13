package cn.zhaoliang5156.learnandroiddevelop.ui.basic.corebasic.component.activity.phoneandsms

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import cn.zhaoliang5156.learnandroiddevelop.R
import kotlinx.android.synthetic.main.activity_phone_and_sms.*

/**
 * 打电话和发短信
 */
class PhoneAndSmsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_and_sms)

        // 动态申请权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS), 1000)
        }

        // 点击跳转到拨打电话的界面
        btn_call.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:" + et_phone_num.text.toString())
            startActivity(intent)
        }
        // 长按拨打电话
        btn_call.setOnLongClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_CALL
            intent.data = Uri.parse("tel:" + et_phone_num.text.toString())
            startActivity(intent)
            true
        }
        // 点击跳转到发送短信的界面
        btn_send.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SENDTO
            intent.data = Uri.parse("smsto:" + et_phone_num.text.toString())
            intent.putExtra("sms_body", et_sms_content.text.toString())
            startActivity(intent)
        }
        // 长按直接发送短信
        btn_send.setOnLongClickListener {
            val manager = SmsManager.getDefault()
            manager.sendTextMessage(et_phone_num.text.toString(), null, et_sms_content.text.toString(), null, null)
            true
        }
    }
}
