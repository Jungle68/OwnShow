package com.jungle68.baseproject.thridmanager.share.impl;


import android.app.Activity;

import com.jungle68.baseproject.thridmanager.share.core.SharePolicy;

import dagger.Module;
import dagger.Provides;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2016/12/15
 * @Contact 335891510@qq.com
 */

@Module
public class ShareModule {
    private Activity mActivity;

    public ShareModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    public SharePolicy provideSharePolicy() {
        return new UmengSharePolicyImpl(mActivity);
    }
}
