package com.cwenhui.meet.di.modules;

import com.cwenhui.data.repository.remote.UserDataRepository;
import com.cwenhui.domain.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

/**
 * 作者: GIndoc
 * 日期: 2017/1/19 10:00
 * 作用:
 */
@Module
public class RepositoryModule {

    @Provides
    public UserRepository provideUserRepository(UserDataRepository repository) {
        return repository;
    }
}

