package com.lyl.mvptest.mvp.jetpack_0701_test

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * User: lyl
 * Date: 2019-07-01 15:51
 */
class ProvinceItemDataSouce :ItemKeyedDataSource<Long,ProvinceBean>() {

    private val apiGenerate by lazy {
        ApiGenerate.getApiService()
    }

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<ProvinceBean>) {
        apiGenerate.getProvince()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(ExecuteOnceObserver(onExecuteOnceNext = {
                    Log.d("lyll","next")
                    Log.d("lyll","data="+it.get(0).name)
                    callback.onResult(it)
                },onExecuteOnceError = {
                    Log.d("lyll","error")
                },onExecuteOnceComplete = {
                    Log.d("lyll","complete")
                }))
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<ProvinceBean>) {
        apiGenerate.getProvince()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(ExecuteOnceObserver(onExecuteOnceNext = {
                    Log.d("lyll","next")
                    callback.onResult(it)
                },onExecuteOnceError = {
                    Log.d("lyll","error")
                },onExecuteOnceComplete = {
                    Log.d("lyll","complete")
                }))
    }

//    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<ProvinceBean>) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun loadBefore(params: LoadParams<Long>, callback:
    LoadCallback<ProvinceBean>) {
        //由于这里不需要向上加载因此省略此处
    }

    override fun getKey(item: ProvinceBean): Long {
        return item.id!!.toLong()
    }

}