package com.company.myBehavioural.memento;

public class Main {
    public static void main(String[] args){
        Article article = new Article();
        History history = new History();

        article.setTitle("title1");
        article.setContent("content1");
        history.push(article.createState());

        article.setTitle("title2");
//        article.setContent("content2");
        history.push(article.createState());

        article.setTitle("title3");
        article.setContent("content3");
        article.restore(history.pop());

        System.out.println(article.getTitle());
        System.out.println(article.getContent());
    }
}
