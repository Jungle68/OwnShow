package com.jungle68.ownshow.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.KeyEvent;

import com.google.gson.Gson;
import com.jungle68.baseproject.base.BaseApplication;
import com.jungle68.baseproject.net.HttpsSSLFactroyUtils;
import com.jungle68.baseproject.net.listener.RequestInterceptListener;
import com.jungle68.baseproject.utils.ActivityHandler;
import com.jungle68.baseproject.utils.LogUtils;
import com.jungle68.ownshow.R;

import javax.net.ssl.SSLSocketFactory;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/26
 * @Contact master.jungle68@gmail.com
 */

public class AppApplication extends BaseApplication {


    public int mActivityCount = 0;
    private AlertDialog alertDialog; // token 过期弹框

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityCallBacks();
    }

    /**
     * dagger 构建
     */
    @Override
    protected void initAppDaggerComponent() {
        /**
         * 初始化Component
         */
        AppComponent appComponent = DaggerAppComponent
                .builder()
                .appModule(getAppModule())// baseApplication 提供
                .httpClientModule(getHttpClientModule())// baseApplication 提供
                .serviceModule(getServiceModule())// 需自行创建
                .cacheModule(getCacheModule())// 需自行创建
                .build();
        AppComponentHolder.setAppComponent(appComponent);
        appComponent.inject(this);
    }

    private void registerActivityCallBacks() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {

            @Override
            public void onActivityStopped(Activity activity) {
                mActivityCount--;
                if (mActivityCount == 0) {// 切到后台
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mActivityCount++;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }
        });
    }

    @Override
    protected String getBaseUrl() {
        return "www.baidu.com";
    }


    /**
     * 这里可以提供一个全局处理http响应结果的处理类,
     * 这里可以比客户端提前一步拿到服务器返回的结果,可以做一些操作,比如token超时,重新获取
     * 默认不实现,如果有需求可以重写此方法
     *
     * @return
     */
    @Override
    public RequestInterceptListener getHttpHandler() {
        return new RequestInterceptListener() {
            @Override
            public Response onHttpResponse(String httpResult, Interceptor.Chain chain, Response
                    response) {
                // 这里可以先客户端一步拿到每一次http请求的结果,可以解析成json,做一些操作,如检测到token过期后
                // token过期，调到登陆页面重新请求token,
                LogUtils.i("baseJson-->" + httpResult);
                handleAuthFail(httpResult);
                return response;
            }

            @Override
            public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
                //如果需要再请求服务器之前做一些操作,则重新返回一个做过操作的的 requeat 如增加 header,不做操作则返回 request
//                AuthBean authBean = mAuthRepository.getAuthBean();
//                if (authBean != null) {
                return chain.request().newBuilder()
                        .header("Accept", "application/json")
                        .header((request.url() + "").contains("v1") ? "ACCESS-TOKEN" : "Authorization", (request.url() + "").contains("v1") ? authBean.getToken() : " Bearer " + authBean.getToken())
                        .build();
//                } else {
//                    return chain.request().newBuilder()
//                            .header("Accept", "application/json")
//                            .build();
//                }
            }
        };
    }

    /**
     * 认证失败弹框
     *
     * @param tipStr
     */
    private void handleAuthFail(final String tipStr) {
        // 跳到登陆页面，销毁之前的所有页面,添加弹框处理提示
        // 通过rxjava在主线程处理弹框
        Observable.empty()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnCompleted(new Action0() {
                    @Override
                    public void call() {
                        if ((alertDialog != null && alertDialog.isShowing())){
//                        ||ActivityHandler.getInstance().currentActivity() instanceof LoginActivity) { // 认证失败，弹框去重
                            return;
                        }
                        alertDialog = new AlertDialog.Builder(ActivityHandler
                                .getInstance().currentActivity(), R.style.TSWarningAlertDialogStyle)
                                .setMessage(tipStr)
                                .setOnKeyListener(new DialogInterface.OnKeyListener() {

                                    @Override
                                    public boolean onKey(DialogInterface dialog, int keyCode,
                                                         KeyEvent event) {
                                        return alertDialog.isShowing() && keyCode == KeyEvent.KEYCODE_BACK
                                                && event.getRepeatCount() == 0;
                                    }
                                })
                                .setPositiveButton(R.string.sure, new
                                        DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface
                                                                        dialogInterface,
                                                                int i) {
                                                // TODO: 2017/2/8  清理登录信息 token 信息
//                                                mAuthRepository.clearAuthBean();
//                                                Intent intent = new Intent
//                                                        (getContext(),
//                                                                LoginActivity
//                                                                        .class);
//                                                ActivityHandler.getInstance()
//                                                        .currentActivity()
//                                                        .startActivity
//                                                                (intent);
                                                alertDialog.dismiss();
                                            }
                                        })
                                .create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        try {
                            alertDialog.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                })
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                })
                .subscribe();
    }


    @NonNull
    protected CacheModule getCacheModule() {
        return new CacheModule();
    }

    @NonNull
    protected ServiceModule getServiceModule() {
        return new ServiceModule();
    }

    @Override
    protected SSLSocketFactory getSSLSocketFactory() {
        int[] a = {R.raw.plus};
        return HttpsSSLFactroyUtils.getSSLSocketFactory(this, a);
    }

    /**
     * 将AppComponent返回出去,供其它地方使用
     *
     * @return
     */
    public static class AppComponentHolder {
        private static AppComponent sAppComponent;

        public static void setAppComponent(AppComponent appComponent) {
            sAppComponent = appComponent;
        }

        public static AppComponent getAppComponent() {
            return sAppComponent;
        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.e("---------------------------------------------onLowMemory---------------------------------------------------");
    }

}
