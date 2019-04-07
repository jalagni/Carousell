package com.carousell.domain;

import com.carousell.domain.executor.PostExecutionThread;
import com.carousell.domain.executor.ThreadExecutor;
import com.carousell.domain.repository.ArticleRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;

import androidx.test.runner.AndroidJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(PowerMockRunner.class)
public class ArticleUseCaseTest {


    private ArticleUseCase articleUser;

    private ArticleRepository mockUserRepository;
    private ThreadExecutor mockThreadExecutor;
    private PostExecutionThread mockPostExecutionThread;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        articleUser = new ArticleUseCase(mockUserRepository, mockThreadExecutor,
                mockPostExecutionThread);
    }

    @Test
    public void testGetUserDetailsUseCaseObservableHappyCase() {
        articleUser.buildUseCaseObservable(ArticleUseCase.Params.getArticle());

        verify(mockUserRepository).getArticles();
        verifyNoMoreInteractions(mockUserRepository);
        verifyZeroInteractions(mockPostExecutionThread);
        verifyZeroInteractions(mockThreadExecutor);
    }

    @Test
    public void testShouldFailWhenNoOrEmptyParameters() {
        expectedException.expect(NullPointerException.class);
        articleUser.buildUseCaseObservable(null);
    }

}
