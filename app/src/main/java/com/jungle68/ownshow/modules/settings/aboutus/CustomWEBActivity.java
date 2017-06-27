package com.jungle68.ownshow.modules.settings.aboutus;

import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.jungle68.baseproject.base.BaseActivity;
import com.jungle68.ownshow.modules.settings.SettingsPresenter;


/**
 * @Describe 关于我们等网页
 * @Author Jungle68
 * @Date 2017/1/10
 * @Contact master.jungle68@gmail.com
 */

public class CustomWEBActivity extends BaseActivity<SettingsPresenter,CustomWEBFragment> {


    @Override
    protected void componentInject() {

    }

    @Override
    protected CustomWEBFragment getFragment() {
        return CustomWEBFragment.newInstance(getIntent().getExtras());
    }

    /**
     * 覆盖系统的回退键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mContanierFragment.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
