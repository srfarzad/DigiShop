package com.navin.digishop.webservice;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class})
public interface ApiComponent {

    ApiCaller getWebserviceCaller();

}
