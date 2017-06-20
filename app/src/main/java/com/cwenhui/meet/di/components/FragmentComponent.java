package com.cwenhui.meet.di.components;


import com.cwenhui.meet.di.modules.FragmentModule;
import com.cwenhui.meet.modules.navigation.index.IndexFragment;

import dagger.Subcomponent;

/**
 * 作者: 陈文辉
 * 日期: 2017/1/17 23:39
 * 作用:
 */
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(IndexFragment indexFragment);
}
