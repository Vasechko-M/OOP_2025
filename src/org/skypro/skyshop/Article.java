package org.skypro.skyshop;

import java.util.Objects;

public class Article implements Searchable{
    private String articleTitle;
    private String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return articleTitle + " " + articleText;
    }
    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(articleTitle, article.articleTitle) && Objects.equals(articleText, article.articleText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleText);
    }
}
