package com.jungle68.ownshow.modules.settings;

import android.view.View;

import com.jungle68.baseproject.base.BaseFragment;
import com.jungle68.baseproject.widget.popupwindow.ActionPopupWindow;
import com.jungle68.ownshow.R;


/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/1/9
 * @Contact master.jungle68@gmail.com
 */
public class SettingsFragment extends BaseFragment<SettingsContract.Presenter> implements SettingsContract.View {



    private ActionPopupWindow mLoginoutPopupWindow;// 退出登录选择弹框
    private ActionPopupWindow mCleanCachePopupWindow;// 清理缓存选择弹框

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    protected int getBodyLayoutId() {
        return R.layout.fragment_settings;
    }

    @Override
    protected String setCenterTitle() {
        return getString(R.string.action_settings);
    }

    @Override
    protected int setToolBarBackgroud() {
        return R.color.white;
    }

    @Override
    protected boolean showToolBarDivider() {
        return true;
    }

    @Override
    protected void initView(View rootView) {
        initListener();
    }

    @Override
    protected void initData() {
        mPresenter.getDirCacheSize();// 获取缓存大小
    }

    @Override
    public void setCacheDirSize(String size) {

    }

    private void initListener() {
        // 退出登录
//        RxView.clicks(mBtLoginOut)
//                .throttleFirst(JITTER_SPACING_TIME, TimeUnit.SECONDS)   //两秒钟之内只取一个点击事件，防抖操作
//                .compose(this.<Void>bindToLifecycle())
//                .subscribe(aVoid -> {
//                    initLoginOutPopupWindow();
//                    mLoginoutPopupWindow.show();
//                });
    }


    /**
     * 初始化清理缓存选择弹框
     */
    private void initCleanCachePopupWindow() {
//        if (mCleanCachePopupWindow != null) {
//            return;
//        }
//        mCleanCachePopupWindow = ActionPopupWindow.builder()
//                .item1Str(getString(R.string.is_sure_clean_cache))
//                .item2Str(getString(R.string.sure))
//                .bottomStr(getString(R.string.cancel))
//                .isOutsideTouch(true)
//                .isFocus(true)
//                .backgroundAlpha(0.8f)
//                .with(getActivity())
//                .item2ClickListener(() -> {
//                    mPresenter.cleanCache();
//                    mCleanCachePopupWindow.hide();
//                })
//                .bottomClickListener(() -> mCleanCachePopupWindow.hide()).build();

    }

    /**
     * 初始化登录选择弹框
     */
    private void initLoginOutPopupWindow() {
//        if (mLoginoutPopupWindow != null) {
//            return;
//        }
//        mLoginoutPopupWindow = ActionPopupWindow.builder()
//                .item1Str(getString(R.string.is_sure_login_out))
//                .item2Str(getString(R.string.login_out_sure))
//                .item2StrColor(ContextCompat.getColor(getContext(), R.color.important_for_note))
//                .bottomStr(getString(R.string.cancel))
//                .isOutsideTouch(true)
//                .isFocus(true)
//                .backgroundAlpha(0.8f)
//                .with(getActivity())
//                .item2ClickListener(() -> {
//                    if (mPresenter.loginOut()) {
//                        startActivity(new Intent(getActivity(), LoginActivity.class));
//                    }
//                    mLoginoutPopupWindow.hide();
//                })
//                .bottomClickListener(() -> mLoginoutPopupWindow.hide()).build();

    }

}
