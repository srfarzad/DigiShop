package com.navin.digishop.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules={UserModule.class})
public interface UserComponent {


    User provideUser();

}
