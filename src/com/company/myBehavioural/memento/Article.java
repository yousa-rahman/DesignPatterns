package com.company.myBehavioural.memento;

public class Article {
    private String title;
    private String content;

    public ArticleState createState(){
        return new ArticleState(title,content);
    }

    public void restore(ArticleState state){
        if(state != null){
            title = state.title;
            content = state.content;
        }
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
