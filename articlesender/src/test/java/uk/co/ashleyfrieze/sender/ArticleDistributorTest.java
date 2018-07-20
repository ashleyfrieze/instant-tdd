package uk.co.ashleyfrieze.sender;

import org.junit.Test;
import uk.co.ashleyfrieze.article.Article;
import uk.co.ashleyfrieze.article.Type;
import uk.co.ashleyfrieze.client.Channel;
import uk.co.ashleyfrieze.database.ArticleDataAccess;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static uk.co.ashleyfrieze.article.Type.SPORT;

public class ArticleDistributorTest {
    @Test
    public void sportGoesToSportPoliticsToOther() {
        Channel sport = mock(Channel.class);
        Channel entertainment = mock(Channel.class);
        Channel other = mock(Channel.class);
        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);

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