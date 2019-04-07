package com.carousell.domain;

import com.carousell.domain.domainModel.Article;
import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;
import com.carousell.domain.utils.DomainHelper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import androidx.test.runner.AndroidJUnitRunner;
import io.reactivex.Observable;
import io.reactivex.Observer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArticleUseCaseTest {

    private ArticleUseCase articleUser;

    @Mock private ArticleRepository mockUserRepository;
    @Mock private ThreadExecutor mockThreadExecutor;
    @Mock private PostExecutionThread mockPostExecutionThread;
    @Mock private DomainHelper dHelper;
    @Mock Observable<List<Article>> observeList;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        articleUser = new ArticleUseCase(dHelper,
                mockUserRepository, mockThreadExecutor,
                mockPostExecutionThread);
    }

    @Test
    public void testArticlesUseCase() {

        when(mockUserRepository.getArticles()).thenReturn(observeList);
        articleUser.buildUseCaseObservable(ArticleUseCase.Params.getArticle());

        verify(mockUserRepository).getArticles();
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);

    }


}
