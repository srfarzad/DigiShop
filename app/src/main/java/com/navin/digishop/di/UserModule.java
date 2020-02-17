package com.navin.digishop.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Provides
    @Singleton
    Contact getContact() {
        return new Contact();
    }

    @Provides
    @Singleton
    User getUser() {
        return new User(new Contact());
    }


}
