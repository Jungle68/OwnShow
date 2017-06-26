package com.jungle68.ownshow.base;

import android.app.Application;

import com.jungle68.baseproject.base.InjectComponent;
import com.jungle68.baseproject.dagger.module.AppModule;
import com.jungle68.baseproject.dagger.module.HttpClientModule;
import com.jungle68.ownshow.data.source.local.CacheManager;
import com.jungle68.ownshow.data.source.remote.ServiceManager;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2016/12/16
 * @Contact 335891510@qq.com
 */

@Singleton
@Component(modules = {AppModule.class, HttpClientModule.class, ServiceModule.class, CacheModule.class})
public interface AppComponent extends InjectComponent<AppApplication> {

//    void inject(MainFragment mainFragment);

    Application Application();

    //服务管理器,retrofitApi
    ServiceManager serviceManager();

    //缓存管理器
    CacheManager cacheManager();


    OkHttpClient okHttpClient();


}
