package com.jungle68.ownshow.modules.settings;

import com.jungle68.baseproject.base.BaseActivity;
import com.jungle68.ownshow.base.AppApplication;

/**
 * @Describe 设置
 * @Author Jungle68
 * @Date 2017/1/9
 * @Contact master.jungle68@gmail.com
 */

public class SettingsActivity extends BaseActivity<SettingsPresenter, SettingsFragment> {

    @Override
    protected void componentInject() {
        DaggerSettingsComponent
                .builder()
                .appComponent(AppApplication.AppComponentHolder.getAppComponent())
                .settingsPresenterModule(new SettingsPresenterModule(mContanierFragment))
                .build()
                .inject(this);

    }


    @Override
    protected SettingsFragment getFragment() {
        return SettingsFragment.newInstance();
    }



}

