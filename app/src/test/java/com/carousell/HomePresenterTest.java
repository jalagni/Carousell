package com.carousell;


import android.content.Context;

import com.carousell.appCore.ViewContract;
import com.carousell.domain.ArticleUseCase;
import com.carousell.homeActivity.HomePresenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.observers.DisposableObserver;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterTest {


    private HomePresenterImpl homePresenterImpl;

    @Mock
    private Context mockContext;
    @Mock private HomePresenterImpl.HomePresenter mockViewContract;
    @Mock private ArticleUseCase mockArticleUseCase;

    @Before
    public void setUp() {
        homePresenterImpl = new HomePresenterImpl(mockArticleUseCase);
        homePresenterImpl.attachView(mockViewContract);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testUserDetailsPresenterInitialize() {

        homePresenterImpl.getArticleList();

        verify(mockViewContract).showLoader();
        verify(mockArticleUseCase).execute(any(DisposableObserver.class), any(ArticleUseCase.Params.class));
    }

}
