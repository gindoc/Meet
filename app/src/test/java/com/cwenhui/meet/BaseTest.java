package com.cwenhui.meet;

import com.cwenhui.meet.utils.RxUnitTestTools;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Author: GIndoc on 2017/6/21 13:56
 * email : 735506583@qq.com
 * FOR   :
 */

public class BaseTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setup() {
        RxUnitTestTools.openRxTools();
    }
}
