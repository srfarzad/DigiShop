package com.navin.digishop.webservice;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {


    @Singleton
    @Provides
    ApiCaller getApi() {
        return new ApiCaller();
    }

}
