package com.jungle68.baseproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import com.jungle68.baseproject.R;
import com.jungle68.baseproject.base.i.IBaseActivity;
import com.jungle68.baseproject.mvp.BasePresenter;
import com.jungle68.baseproject.utils.ActivityHandler;
import com.jungle68.baseproject.utils.ActivityUtils;
import com.jungle68.baseproject.utils.LanguageUtils;
import com.umeng.analytics.MobclickAgent;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import skin.support.app.SkinCompatActivity;

/**
 * @Describe Activity 基类
 * @Author Jungle68
 * @Date 2016/12/14
 * @Contact 335891510@qq.com
 */

public abstract class BaseActivity<P extends BasePresenter, F extends Fragment> extends SkinCompatActivity implements
        IBaseActivity {
    protected final String TAG = this.getClass().getSimpleName();

    protected BaseApplication mApplication;
    protected F mContanierFragment;
    @Inject
    protected P mPresenter;
    private Unbinder mUnbinder;
    protected LayoutInflater mLayoutInflater;
    public boolean mIsForeground; // 用于应用是否处于前台还是后台的判断；

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            restoreData(savedInstanceState);
        }
        mApplication = (BaseApplication) getApplication();
        ActivityHandler.getInstance().addActivity(this);
        mLayoutInflater = LayoutInflater.from(this);
        // 如果要使用 eventbus 请将此方法返回 true
        if (useEventBus()) {
            EventBus.getDefault().register(this);// 注册到事件主线
        }
        setContentView(getLayoutId());
        // 绑定到 butterknife
        mUnbinder = ButterKnife.bind(this);
        if (isNeedFragment()) {
            // 添加fragment
            mContanierFragment = getFragment();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mContanierFragment, R.id.fl_fragment_container);
        }
        initView();
        componentInject();// 依赖注入，必须放在initview后，否者
        initData();
        // 语言支持
        LanguageUtils.changeAppLanguage(getApplicationContext(), LanguageUtils.getAppLocale(getApplicationContext()));
    }

    protected boolean isNeedFragment() {
        return true;
    }

    protected int getLayoutId() {
        return R.layout.activity_ts;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        mIsForeground = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsForeground = false;
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityHandler.getInstance().removeActivity(this);
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        if (useEventBus())// 如果要使用 eventbus 请将此方法返回 true
            EventBus.getDefault().unregister(this);
    }

    /**
     * 是否使用 eventBus,默认为使用(true)，
     *
     * @return
     */
    protected boolean useEventBus() {
        return false;
    }

    /**
     * 依赖注入的入口
     */
    protected abstract void componentInject();


    protected void initView() {

    }

    protected void initData() {

    }

    /**
     * @return 当前页的Fragment
     */
    protected abstract F getFragment();

    /**
     * 读取关闭时保存的数据
     *
     * @param savedInstanceState
     */
    protected void restoreData(Bundle savedInstanceState) {
    }

    /**
     * 关闭时保存数据
     *
     * @param savedInstanceState
     * @return
     */
    protected Bundle saveData(Bundle savedInstanceState) {
        return savedInstanceState;
    }


}
