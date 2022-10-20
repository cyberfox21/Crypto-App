package com.cyberfox21.cryptoapp.presentation.currency_list;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

/**
 * @author t.shkolnik
 */
public class CurrencyListViewModel extends ViewModel implements LifecycleObserver {

//    @Inject


//    public CurrencyListViewModel(MyRepository myRepository,
//                                 SavedStateHandle savedStateHandle) {
//    }

    public CurrencyListViewModel() {}

    static final ViewModelInitializer<CurrencyListViewModel> initializer = new ViewModelInitializer<>(
            CurrencyListViewModel.class,
            creationExtras -> {
//                App app = (App) creationExtras.get(APPLICATION_KEY);
//                assert app != null;
//                SavedStateHandle savedStateHandle = createSavedStateHandle(creationExtras);

//                return new CurrencyListViewModel(app.getMyRepository(), savedStateHandle);
                return new CurrencyListViewModel();
            }
    );
}

