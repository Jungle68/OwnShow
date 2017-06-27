package com.jungle68.ownshow.base;


import com.jungle68.ownshow.data.source.remote.CommonClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/26
 * @Contact master.jungle68@gmail.com
 */

@Module
public class ServiceModule {
    /**
     * 公用相关的网络接口
     *
     * @param retrofit 网络框架
     * @return
     */
    @Singleton
    @Provides
    CommonClient provideCommonService(Retrofit retrofit) {
        return retrofit.create(CommonClient.class);
    }
//
//    /**
//     * 登录相关的网络接口
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    LoginClient provideLoginClient(Retrofit retrofit) {
//        return retrofit.create(LoginClient.class);
//    }
//
//    /**
//     * 密码相关的网络接口
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    PasswordClient providePasswordClient(Retrofit retrofit) {
//        return retrofit.create(PasswordClient.class);
//    }
//
//    /**
//     * 用户信息的网络接口
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    UserInfoClient provideUserInfoClient(Retrofit retrofit) {
//        return retrofit.create(UserInfoClient.class);
//    }
//
//    /**
//     * 聊天信息的网络接口
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    ChatInfoClient provideChatInfoClient(Retrofit retrofit) {
//        return retrofit.create(ChatInfoClient.class);
//    }
//
//    /**
//     * 注册相关的网络接口
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    RegisterClient provideRegisterClient(Retrofit retrofit) {
//        return retrofit.create(RegisterClient.class);
//    }
//
//    /**
//     * 音乐FM
//     *
//     * @param retrofit 网络框架
//     * @return
//     */
//    @Singleton
//    @Provides
//    MusicClient provideMusicClient(Retrofit retrofit) {
//        return retrofit.create(MusicClient.class);
//    }
//
//    /**
//     * 资讯-资讯分类列表
//     *
//     * @param retrofit
//     * @return
//     */
//    @Singleton
//    @Provides
//    InfoMainClient provideInfoMainClient(Retrofit retrofit) {
//        return retrofit.create(InfoMainClient.class);
//    }
//
//    /**
//     * 获取粉丝关注列表网络接口
//     *
//     * @param retrofit
//     * @return
//     */
//    @Singleton
//    @Provides
//    FollowFansClient provideFollowFansClient(Retrofit retrofit) {
//        return retrofit.create(FollowFansClient.class);
//    }
//
//    @Singleton
//    @Provides
//    DynamicClient provideDynamicClient(Retrofit retrofit) {
//        return retrofit.create(DynamicClient.class);
//    }
//
//    @Singleton
//    @Provides
//    ChannelClient provideChannelClient(Retrofit retrofit) {
//        return retrofit.create(ChannelClient.class);
//    }
//
//    @Singleton
//    @Provides
//    CommonCommentClient provideCommonCommentClient(Retrofit retrofit) {
//        return retrofit.create(CommonCommentClient.class);
//    }
//
//    @Singleton
//    @Provides
//    HomePageClient providHomePageClient(Retrofit retrofit){
//        return retrofit.create(HomePageClient.class);
//    }
//
//    @Singleton
//    @Provides
//    ReadClient provideReadClient(Retrofit retrofit){
//        return retrofit.create(ReadClient.class);
//    }
//
//    @Singleton
//    @Provides
//    SportClient provideSportClient(Retrofit retrofit){
//        return retrofit.create(SportClient.class);
//    }
//
//    @Singleton
//    @Provides
//    WalletClient provideWalletClient(Retrofit retrofit){
//        return retrofit.create(WalletClient.class);
//    }

}
