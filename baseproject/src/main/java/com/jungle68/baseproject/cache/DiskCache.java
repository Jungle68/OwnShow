package com.jungle68.baseproject.cache;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author LiuChao
 * @describe 本地磁盘缓存，实现缓存接口，当前使用数据库做持久化保存
 * @date 2017/1/6
 * @contact email:450127106@qq.com
 */

public class DiskCache<T extends CacheBean> implements ICache<T> {

    // 数据库实现类的公共接口
    private IDataBaseOperate<T> mDataBaseOperate;

    public DiskCache(IDataBaseOperate<T> commonCache) {
        mDataBaseOperate = commonCache;
    }

    @Override
    public Observable<T> get(final Long key) {
        return Observable.create((Observable.OnSubscribe<T>) subscriber -> {
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = mDataBaseOperate.getSingleDataFromCache(key);

            subscriber.onNext(t);
            subscriber.onCompleted();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void put(Long key, T t) {
        mDataBaseOperate.saveSingleData(t);
    }
}
