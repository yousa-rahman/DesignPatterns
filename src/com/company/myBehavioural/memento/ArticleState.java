package com.company.myBehavioural.memento;

public class ArticleState {
    final String title;
    final String content;

    public ArticleState(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
