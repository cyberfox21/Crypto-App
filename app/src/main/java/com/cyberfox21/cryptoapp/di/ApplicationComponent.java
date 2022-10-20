package com.cyberfox21.cryptoapp.di;

import com.cyberfox21.cryptoapp.App;

import dagger.Component;

/**
 * @author t.shkolnik
 */
@Component(
        modules = {NetworkModule.class, DomainModule.class}
)
public interface ApplicationComponent {

//    void inject(App app);
}
