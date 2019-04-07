package com.carousell.data;

import com.carousell.data.dataSource.ArticleCloudRepository;
import com.carousell.data.network.ApiService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArticleCloudReposTest {

    private ArticleCloudRepository articleCloudRepository;


    @Mock private ApiService mockApiService;
    @Mock private DomainDataMapper mockDataMapper;
    @Mock private Observable observable;

    @Before
    public void setup(){
        articleCloudRepository = new ArticleCloudRepository(mockApiService,mockDataMapper);
    }

    @Test
    public void testArticleList(){
        when(mockApiService.getArticleList()).thenReturn(observable);
        articleCloudRepository.getArticles();
        verifyZeroInteractions(observable);
    }

}
