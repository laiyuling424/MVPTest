package com.lyl.httpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Route
import com.lyl.baselibrary.ARouterMap
import com.qudaox.myapplication.R

@Route(path = ARouterMap.httpapp_mainactivity)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdata()
        geterrordata()
    }

    private fun getdata() {
        NetUtil.sendJsonRequest("https://www.wanandroid.com/wxarticle/chapters/json", null, WeChatPublicListBeanResponse::class.java,
                object : IJsonDataListener<WeChatPublicListBeanResponse> {
                    override fun onSuccess(t: WeChatPublicListBeanResponse?) {
                        Log.d("lyll", "response====>$t")
                    }
                    override fun onFailure() {

                    }
                })
    }

    private fun geterrordata() {
        NetUtil.sendJsonRequest("https://xxxxxxxxx", null, WeChatPublicListBeanResponse::class.java,
                object : IJsonDataListener<WeChatPublicListBeanResponse> {
                    override fun onSuccess(t: WeChatPublicListBeanResponse?) {
                        Log.d("lyll", "response====>$t")
                    }
                    override fun onFailure() {

                    }
                })
    }
}
