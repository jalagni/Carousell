package com.carousell.appSupport;



import com.carousell.R;
import com.carousell.appCore.BaseActivity;
import com.carousell.appCore.BaseFragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import timber.log.Timber;

public class NavMngr {

    private static NavMngr navMngr;

    public static NavMngr getInstance() {
        if (navMngr == null) {
            navMngr = new NavMngr();
        }

        return navMngr;
    }

    private NavMngr() {
    }

    private BaseActivity baseActivity;

    public void registerActivity(BaseActivity activity) {
        this.baseActivity = activity;
    }

    public void pushFragment(BaseFragment bFragment) {

        if (baseActivity == null) {
            throw new RuntimeException("No Activity registerd");
        }


        FragmentTransaction ft = baseActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainContainer, bFragment, bFragment.getClass().toString());
        ft.addToBackStack(bFragment.getClass().toString());

        ft.commit();

    }

    public BaseFragment getFragmentOnTop(){
        FragmentManager fManager = baseActivity.getSupportFragmentManager();

        BaseFragment bFragment = (BaseFragment) fManager.getFragments()
                .get(fManager.getBackStackEntryCount() - 1 );

        return bFragment;
    }
    public boolean isLastFragment() {
        FragmentManager fManager = baseActivity.getSupportFragmentManager();
        Timber.e("Count :" + fManager.getBackStackEntryCount());
        return fManager.getBackStackEntryCount() == 1;

    }


    public void popFragment() {
        FragmentManager fManager = baseActivity.getSupportFragmentManager();
        fManager.popBackStack();
    }

}
