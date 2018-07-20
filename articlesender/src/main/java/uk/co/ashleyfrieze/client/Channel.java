package uk.co.ashleyfrieze.client;

import uk.co.ashleyfrieze.article.Article;

/**
 * A target for relevant articles
 */
public interface Channel {
    /**
     * Call this to send an article to its destination.
     * @param article the article to send
     */
    void accept(Article article);
}
