package cn.com.farmcode.utilities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.com.farmcode.utility.tools.Logger

class MainActivity : AppCompatActivity() {
    val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Logger.setContainTrace(false)
        Logger.d("onResume")
        Logger.d(TAG,"onResume")
        Logger.setContainTrace(true)
        Logger.i("onResume")
        Logger.i(TAG,"onResume")
        Logger.setPrintAble(false)
        Logger.w("onResume")
        Logger.w(TAG,"onResume")
        Logger.setPrintAble(true)
        Logger.e("onResume")
        Logger.e(TAG,"onResume")
    }
}
