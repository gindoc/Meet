package com.cwenhui.meet.modules.login;

import com.cwenhui.domain.model.User;
import com.cwenhui.meet.base.IBasePresenter;
import com.cwenhui.meet.base.IBaseView;

/**
 * Author: GIndoc on 2017/6/15 16:38
 * email : 735506583@qq.com
 * FOR   :
 */
public interface LoginContract {
    interface View extends IBaseView {

        void loadResult(User user);
    }

    interface Presenter extends IBasePresenter {
        void login(String username, String pwd);
    }
}