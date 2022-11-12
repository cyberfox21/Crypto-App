package com.cyberfox21.cryptoapp.di;

import dagger.Component;

/**
 * @author t.shkolnik
 */
@Component(
        modules = {DataModule.class, DomainModule.class}
)
public interface ApplicationComponent {

//    void inject(App app);
}
