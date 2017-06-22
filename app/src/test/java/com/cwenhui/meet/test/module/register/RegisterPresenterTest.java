package com.cwenhui.meet.test.module.register;

import com.cwenhui.domain.usecase.UserCase;
import com.cwenhui.meet.BaseTest;
import com.cwenhui.meet.modules.register.RegisterContract;
import com.cwenhui.meet.modules.register.RegisterPresenter;

import org.mockito.InjectMocks;
import org.mockito.Mock;

/**
 * Author: GIndoc on 2017/6/21 13:58
 * email : 735506583@qq.com
 * FOR   :
 */

public class RegisterPresenterTest extends BaseTest {

    @InjectMocks
    private RegisterPresenter mPresenter;

    private RegisterContract.View registerView;

    @Mock
    UserCase userCase;

    @Override
    public void setup() {
        super.setup();

    }
}
