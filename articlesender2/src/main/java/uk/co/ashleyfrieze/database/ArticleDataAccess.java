package uk.co.ashleyfrieze.database;

import uk.co.ashleyfrieze.article.Article;

import java.util.List;

public interface ArticleDataAccess {
    /**
     * @return all the articles from today
     */
    List<Article> getTodaysArticles();
}
