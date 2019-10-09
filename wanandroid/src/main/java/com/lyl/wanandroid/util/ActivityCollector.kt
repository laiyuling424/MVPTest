package com.lyl.wanandroid.util

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.ArrayList

/**
 * Create By: lyl
 * Date: 2019-06-11 13:56
 *
 * 应用中所有Activity的管理器，可用于一键杀死所有Activity。
 */
object ActivityCollector {

    private const val TAG = "ActivityCollector"

    private val activityList = ArrayList<WeakReference<Activity>?>()

    fun size(): Int {
        return activityList.size
    }

    fun add(weakRefActivity: WeakReference<Activity>?) {
        activityList.add(weakRefActivity)
    }

    fun remove(weakRefActivity: WeakReference<Activity>?) {
        val result = activityList.remove(weakRefActivity)
        MyLog.Logi(TAG, "remove activity reference $result")
    }

    fun finishAll() {
        if (activityList.isNotEmpty()) {
            for (activityWeakReference in activityList) {
                val activity = activityWeakReference?.get()
                if (activity != null && !activity.isFinishing) {
                    activity.finish()
                }
            }
            activityList.clear()
        }
    }

}