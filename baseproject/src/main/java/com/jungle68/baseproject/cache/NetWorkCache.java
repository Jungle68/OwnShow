package com.jungle68.baseproject.cache;

import rx.Observable;

/**
 * @author LiuChao
 * @describe
 * @date 2017/1/6
 * @contact email:450127106@qq.com
 */

public interface NetWorkCache<T extends CacheBean> {
    Observable<T> get(Long key);
}
