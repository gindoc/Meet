package com.cwenhui.meet.modules.login;

/**
 * Author: GIndoc on 2017/6/22 17:36
 * email : 735506583@qq.com
 * FOR   : 用户登录状态管理类
 */

public class LoginContext {

    private static final class SingletonHolder {
        private static final LoginContext INSTANCE = new LoginContext();
    }

    public static LoginContext getLoginContext() {
        return SingletonHolder.INSTANCE;
    }

    private LoginContext() {
    }

    private UserSate userSate = new LogoutState();      // 默认未登录状态


    public void setUserSate(UserSate userSate) {
        this.userSate = userSate;
    }

}
