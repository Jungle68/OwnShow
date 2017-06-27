package com.jungle68.ownshow.data.source.local.db;

import android.content.Context;

import com.jungle68.baseproject.utils.LogUtils;
import com.jungle68.ownshow.data.beans.DaoMaster;

import org.greenrobot.greendao.database.Database;


/**
 * @Describe
 * @Author Jungle68
 * @Date 2017/6/26
 * @Contact master.jungle68@gmail.com
 */

public class UpDBHelper extends DaoMaster.OpenHelper {
    public static final String DB_NAME="test.db";

    public UpDBHelper(Context context, String name) {
        super(context, name);
    }

    // 注意选择GreenDao参数的onUpgrade方法
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        LogUtils.i("greenDAO",
                "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");

        // 每次升级，将需要更新的表进行更新，第二个参数为要升级的Dao文件.

//        MigrationHelper.getInstance().migrate(db, StepBeanDao.class);
    }
}
