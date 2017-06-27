package com.jungle68.ownshow.modules.settings;


import com.jungle68.baseproject.base.InjectComponent;
import com.jungle68.baseproject.dagger.scope.ActivityScoped;
import com.jungle68.ownshow.base.AppComponent;

import dagger.Component;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2016/12/28
 * @Contact master.jungle68@gmail.com
 */
@ActivityScoped
@Component(dependencies = AppComponent.class, modules = SettingsPresenterModule.class)
public interface SettingsComponent extends InjectComponent<SettingsActivity> {
}

