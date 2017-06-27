package com.jungle68.ownshow.data.beans;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import com.jungle68.ownshow.data.beans.UserInfo;
import com.jungle68.ownshow.data.beans.UserInfoDao;

public class UserInfoTest extends AbstractDaoTestLongPk<UserInfoDao, UserInfo> {

    public UserInfoTest() {
        super(UserInfoDao.class);
    }

    @Override
    protected UserInfo createEntity(Long key) {
        UserInfo entity = new UserInfo();
        entity.setId(key);
        return entity;
    }

}
