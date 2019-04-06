package com.carousell.homeActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.carousell.R;
import com.carousell.appCallBack.ListCallBack;
import com.carousell.appCallBack.SortComparator;
import com.carousell.appCore.BaseFragment;
import com.carousell.data.dataModel.ArticleModel;
import com.carousell.databinding.FragmentHomeBinding;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import timber.log.Timber;

public class HomeFragment extends BaseFragment
        implements HomePresenterImpl.HomePresenter, ListCallBack {


    private FragmentHomeBinding layoutHomeBinding;
    private ArticleAdapter aAdapter;


    @Inject
    HomePresenterImpl hPresenter;


    public static HomeFragment newInstance() {
        HomeFragment hFragment = new HomeFragment();
        return hFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMainApp().getAppComponent().setHomeComponent().
                inject(this);

        hPresenter.attachView(this);
        aAdapter = new ArticleAdapter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if(layoutHomeBinding != null){
            return layoutHomeBinding.getRoot();
        }

        View view = inflater.inflate(R.layout.fragment_home, null);
        layoutHomeBinding = DataBindingUtil.bind(view);

        LinearLayoutManager lMngr = new LinearLayoutManager(bActivity, RecyclerView.VERTICAL, false);
        layoutHomeBinding.rArticle.setLayoutManager(lMngr);


        return layoutHomeBinding.getRoot();

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(bActivity, msg, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onViewInitialized() {
        layoutHomeBinding.rArticle.setAdapter(aAdapter);
        hPresenter.getArticleList();
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_recent :
                aAdapter.setComparator(SortComparator.TYPE.DATE);
                break;
            case R.id.action_popular:
                aAdapter.setComparator(SortComparator.TYPE.POPULAR);
                break;
        }
        return true;
    }



    @Override
    public void onArticleRecieved(ArrayList<ArticleModel> listModel) {
        aAdapter.setContent(listModel);
    }


    @Override
    public void listCall(int type, Object object) {

    }
}
