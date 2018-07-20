package uk.co.ashleyfrieze.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.co.ashleyfrieze.article.Article;
import uk.co.ashleyfrieze.article.Type;
import uk.co.ashleyfrieze.client.Channel;
import uk.co.ashleyfrieze.client.EntertainmentChannel;
import uk.co.ashleyfrieze.client.OtherChannel;
import uk.co.ashleyfrieze.client.SportsChannel;
import uk.co.ashleyfrieze.database.ArticleDataAccess;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static uk.co.ashleyfrieze.article.Type.SPORT;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {
    @Mock
    private SportsChannel sport;

    @Mock
    private EntertainmentChannel entertainment;

    @Mock
    private OtherChannel other;

    @Mock
    private ArticleDataAccess dataAccess;

    @InjectMocks
    private ArticleDistributor distributor;

    @Test
    public void sportGoesToSportPoliticsToOther() {
        // given this list of articles is returned from the database
        List<Article> list = asList(
                new Article("Sport is fun", SPORT),
                new Article("Politics is sad", Type.POLITICS));

        when(dataAccess.getTodaysArticles()).thenReturn(list);

        // when we distribute
        distributor.distributeTodays();

        // then one goes to sport and one goes to other
        verify(sport).accept(any());
        verify(other).accept(any());
        verify(entertainment, never()).accept(any());

    }
}