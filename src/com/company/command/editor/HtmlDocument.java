package com.company.command.editor;

public class HtmlDocument {
    private String content;

    public void bold(){
        content = "<b>" + content + "</b>";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
