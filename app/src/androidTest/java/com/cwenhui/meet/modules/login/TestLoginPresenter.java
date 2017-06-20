package com.cwenhui.meet.modules.login;

import com.cwenhui.domain.model.User;
import com.cwenhui.domain.usecase.UserCase;
import com.trello.rxlifecycle.LifecycleTransformer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author: GIndoc on 2017/6/15 18:30
 * email : 735506583@qq.com
 * FOR   :
 */
//@RunWith(MockitoJUnitRunner.class)
public class TestLoginPresenter {
    private LoginPresenter mPresenter;

    @Mock
    private LoginContract.View loginView;

    @Mock
    private UserCase userCase;

    @Mock
    LifecycleTransformer lifecycleTransformer;

    @Before
    public void setup() {
        mPresenter = new LoginPresenter(userCase);
        mPresenter.attachView(loginView);
    }

    @Test
    public void testLogin() {
        when(loginView.getBindToLifecycle()).thenReturn(lifecycleTransformer);
        mPresenter.login(anyString(), anyString());
        verify(loginView).getBindToLifecycle();
        verify(loginView).loadResult(any(User.class));
    }
}
