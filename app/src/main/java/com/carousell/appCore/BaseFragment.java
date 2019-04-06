package com.carousell.appCore;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.carousell.R;
import com.carousell.appSupport.AppLoader;
import com.carousell.mainApp.MainApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment implements ViewContract {

    private View rootView;

    protected BaseActivity bActivity;

    protected AppLoader aLoader;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        bActivity = (BaseActivity) getActivity();
        aLoader = new AppLoader(bActivity);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (rootView != null)
            return;


        super.onViewCreated(view, savedInstanceState);
        onViewInitialized();
        rootView = view;
    }

    public MainApp getMainApp() {
        return (MainApp) bActivity.getApplication();
    }

    protected void onViewInitialized() {
    }

    protected boolean isBackHandled() {
        return false;
    }


    @Override
    public void showLoader() {
        aLoader.showLoader();
    }

    @Override
    public void hideLoader() {
        aLoader.hideLoader();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }


}
