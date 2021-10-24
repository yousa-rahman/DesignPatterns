package com.company.behaviouralPattern.memento;

public class Editor {
    private String content;

    public EditorState createState(){
        return new EditorState(content);
    }

    public void restore(EditorState state){
        if(state != null)
            content = state.getContent();
    }

    public void  setContent(String input) {
        this.content = input;
    }

    public String getContent() {
        return content;
    }




}
