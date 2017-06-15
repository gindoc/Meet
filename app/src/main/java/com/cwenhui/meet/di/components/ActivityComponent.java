package com.cwenhui.meet.di.components;

import com.cwenhui.meet.di.modules.ActivityModule;
import com.cwenhui.meet.di.modules.FragmentModule;

import dagger.Subcomponent;

/**
 * 作者: 陈文辉
 * 日期: 2017/1/17 23:39
 * 作用:
 */
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    FragmentComponent plus(FragmentModule module);

}
