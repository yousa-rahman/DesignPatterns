package com.company.memento;

public class Editor {
    private String content;

    public EditorState createState(){
        return new EditorState(content);
    }

    public void restore(EditorState state){
        content = state.getContent();
    }

    public void  setContent(String input) {
        this.content = input;
    }

    public String getContent() {
        return content;
    }




}