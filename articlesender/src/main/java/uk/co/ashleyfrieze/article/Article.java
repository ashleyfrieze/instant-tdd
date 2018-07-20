package uk.co.ashleyfrieze.article;

/**
 * An article a client may be interested in
 */
public class Article {
    private String content;
    private Type type;

    public Article(String content, Type type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public Type getType() {
        return type;
    }
}
