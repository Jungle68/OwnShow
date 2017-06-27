package com.jungle68.ownshow.data.source.local.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jungle68.baseproject.base.BaseApplication;
import com.jungle68.baseproject.cache.IDataBaseOperate;
import com.jungle68.ownshow.data.beans.DaoMaster;
import com.jungle68.ownshow.data.beans.DaoSession;

/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/26
 * @Contact master.jungle68@gmail.com
 */


public abstract class CommonCacheImpl<T> implements IDataBaseOperate<T> {
    private static final UpDBHelper sUpDBHelper = new UpDBHelper(BaseApplication.getContext(), UpDBHelper.DB_NAME);

    public CommonCacheImpl(Context context) {
    }

    /**
     * 获取可读数据库
     */
    protected SQLiteDatabase getReadableDatabase() {
        return  sUpDBHelper.getReadableDatabase();

    }

    /**
     * 获取可写数据库
     */
    protected SQLiteDatabase getWritableDatabase() {
        return sUpDBHelper.getWritableDatabase();
    }

    /**
     * 获取可写数据库的DaoMaster
     */
    protected DaoMaster getWDaoMaster() {
        return  new DaoMaster(getWritableDatabase());
    }

    /**
     * 获取可写数据库的DaoSession
     */
    protected DaoSession getWDaoSession() {
        return getWDaoMaster().newSession();
    }

    /**
     * 获取可写数据库的DaoMaster
     */
    protected DaoMaster getRDaoMaster() {
        return new DaoMaster(getWritableDatabase());
    }

    /**
     * 获取可写数据库的DaoSession
     */
    protected DaoSession getRDaoSession() {
        return  getRDaoMaster().newSession();
    }
}
