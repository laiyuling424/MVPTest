package com.lyl.wanandroid.http

import com.lyl.wanandroid.ui.fragment.first.wechatpublic.WeChatPublicListBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * User: lyl
 * Date: 2019-07-05 17:50
 */
interface Api {

    //公众号列表
    @GET("wxarticle/chapters/json")
    fun getWeChatPublicList():Observable<List<WeChatPublicListBean>>

    //某个公众号历史数据
    /**
     * @param id 公众号列表id
     * @param page 页码
     */
    @GET("wxarticle/list/{id}/{page}/json")
    fun getWeChatPublicHistoryData(@Path("id") id: Int,@Path("page") page: Int):Observable<List<WeChatPublicListBean>>
}