package com.futou.cpad.userCenter.businessService.user.vo;

import com.futou.cpcad.userCenter.db.domain.UserMobile;
import com.futou.cpcad.userCenter.db.domain.UserWx;

public class UserInfoVo {

    private UserMobile userMobile;

    private UserWx userWx;

    public UserMobile getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(UserMobile userMobile) {
        this.userMobile = userMobile;
    }

    public UserWx getUserWx() {
        return userWx;
    }

    public void setUserWx(UserWx userWx) {
        this.userWx = userWx;
    }
}
