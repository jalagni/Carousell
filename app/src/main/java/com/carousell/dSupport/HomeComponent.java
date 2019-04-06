package com.carousell.dSupport;



import com.carousell.homeActivity.HomeFragment;
import com.carousell.homeActivity.HomePresenterImpl;

import dagger.Subcomponent;

@Subcomponent
public interface HomeComponent {

    void inject(HomeFragment hFragment);

    HomePresenterImpl getHomePresenter();

}
