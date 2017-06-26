package com.jungle68.ownshow.data.source.remote;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2016/12/16
 * @Contact 335891510@qq.com
 */

public interface CommonClient {
//    /**
//     * 验证码类型
//     * register: 注册
//     * login: 登录
//     * change: 修改,找回密码
//     */
//
//    String VERTIFY_CODE_TYPE_REGISTER = "register";
//    String VERTIFY_CODE_TYPE_LOGIN = "login";
//    String VERTIFY_CODE_TYPE_CHANGE = "change";
//
//
//    /*******************************************  系统相关  *********************************************/
//
//
//    /**
//     * 获取验证码
//     *
//     * @param requestState {requestState}=success/fasle
//     * @param phone        需要被发送验证码的手机号
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(APP_GET_CODE)
//    Observable<CodeBean> getVertifyCode(@Query("requestState") String requestState, @Field("phone") String phone);
//
//    /**
//     * 刷新 token
//     *
//     * @param deviceCode  设备号
//     * @param refrshToken 刷新token
//     * @return 成功后自动调用auth接口，返回信息和login一样
//     */
//    @PATCH(APP_PATH_REFRESH_TOKEN)
//    Observable<BaseJson<AuthBean>> refreshToken(@Query("refresh_token") String refrshToken, @Query("device_code") String deviceCode);
//
//    /**
//     * 查看扩展包安装状态
//     *
//     * @return
//     */
//    @GET(APP_PATH_GET_COMPONENT_STATUS)
//    Observable<BaseJson<ComponentStatusBean>> getComponentStatus();
//
//    /**
//     * 获取扩展包配置信息
//     *
//     * @param component
//     * @return
//     */
//    @GET(APP_PATH_GET_COMPONENT_CONFIGS)
//    Observable<BaseJson<List<ComponentConfigBean>>> getComponentConfigs(@Query("component") String component);
//
//    /**
//     * 意见反馈
//     *
//     * @param content
//     * @return
//     */
//    @FormUrlEncoded
//    @POST(APP_PATH_SYSTEM_FEEDBACK)
//    Observable<BaseJson<Object>> systemFeedback(@Field("content") String content, @Field("system_mark") long system_mark);
//
//    /**
//     * 获取系统会话列表
//     *
//     * @param max_id
//     * @param limit
//     * @return
//     */
//    @GET(APP_PATH_GET_SYSTEM_CONVERSATIONS)
//    Observable<BaseJson<List<SystemConversationBean>>> getSystemConversations(@Query("max_id") long max_id, @Query("limit") int limit);
//
//
//    /*******************************************  文件上传  *********************************************/
//
//    /**
//     * 储存任务创建
//     * <p>
//     * hash            待上传文件hash值，hash方式md5
//     * origin_filename 原始文件名称
//     * mime_type       文件mimeType
//     * width           图片宽度
//     * height          图片高度
//     *
//     * @param fieldMap 参数map
//     */
//    @FormUrlEncoded
//    @POST(APP_PATH_CREATE_STORAGE_TASK)
//    Observable<BaseJson<StorageTaskBean>> createStorageTask(@FieldMap HashMap<String, String> fieldMap, @Query("requestState") String requestState);
//
//    /**
//     * 校验文件hash
//     *
//     * @param hash 文件 MD5 值
//     * @return
//     */
//    @GET(APP_PATH_STORAGE_HASH)
//    Observable<BaseJsonV2> checkStorageHash(@Path("hash") String hash);
//
//
//    @FormUrlEncoded
//    @POST(APP_UPLOAD_PATH)
//    Observable<UpLoadBean> upLoadSinglePic(@Field("hash") String fileHash,
//                                           @Field("mime_type") String mime_type, @Field("origin_filename") String fileName,
//                                           @Field("width") float width, @Field("height") float height);
//
//    /**
//     * 通过Post方法上传文件
//     */
//    @Multipart
//    @POST
//    Observable<String> upLoadFileByPost(@Url String url, @HeaderMap HashMap<String, String> headers, @Part List<MultipartBody.Part> params);
//
//    /**
//     * 通过Put方法上传文件
//     */
//    @Multipart
//    @PUT
//    Observable<String> upLoadFileByPut(@Url String url, @HeaderMap HashMap<String, String> headers, @Part List<MultipartBody.Part> params);
//
//
//    /**
//     * 通过Post方法上传文件 V2
//     */
//    @Multipart
//    @POST(APP_PATH_STORAGE_UPLAOD_FILE)
//    Observable<BaseJsonV2> upLoadFileByPostV2(@Part List<MultipartBody.Part> params);
//
//    /**
//     * 通过Put方法上传文件 V2
//     */
//    @Multipart
//    @PUT
//    Observable<BaseJson> upLoadFileByPutV2(@Part List<MultipartBody.Part> params);
//
//    /**
//     * 储存任务通知
//     *
//     * @param storage_task_id 任务ID
//     * @param message         附加上传接口返回的原样数据
//     * @return 返回将以通用message格式返回上传的附件是成功还是失败等状态信息。
//     */
//    @FormUrlEncoded
//    @PATCH(APP_PATH_NOTIFY_STORAGE_TASK)
//    Observable<BaseJson> notifyStorageTask(@Path("storage_task_id") String storage_task_id, @Field("message") String message, @Query("requestState") String requestState);
//
//    /**
//     * 通知服务器，删除当前上传文件
//     *
//     * @param storage_task_id 任务ID
//     */
//    @DELETE(APP_PATH_DELETE_STORAGE_TASK)
//    Observable<BaseJson> deleteStorageTask(@Path("storage_task_id") String storage_task_id, @Query("requestState") String requestState);
//
//
//    /*******************************************  后台任务处理  *********************************************/
//
//    /**
//     * 后台任务处理
//     */
//    @Multipart
//    @POST(APP_PATH_HANDLE_BACKGROUND_TASK)
//    Observable<BaseJson<Object>> handleBackGroundTaskPost(@Path("path") String path, @Part List<MultipartBody.Part> partList);
//
//    @Headers({"Content-type:application/json;charset=UTF-8"})
//    @HTTP(method = "DELETE", path = APP_PATH_HANDLE_BACKGROUND_TASK, hasBody = true)
//    Observable<BaseJson<CacheBean>> handleBackGroudTaskDelete(@Path("path") String path, @Body RequestBody requestBody);
//
//
//    /**
//     * rap接口，用来测试token过期,当前返回token过期
//     *
//     * @return
//     */
//    @POST(APP_PATH_TOKEN_EXPIERD)
//    Observable<BaseJson> testTokenExpierd(@Query("requestState") String requestState);
//
//    @Multipart
//    @PATCH(APP_PATH_HANDLE_BACKGROUND_TASK)
//    Observable<BaseJson<Object>> handleBackGroundTaskPatch(@Path("path") String path, @Part List<MultipartBody.Part> partList);
}