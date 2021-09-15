package com.company;

import com.company.momento.Editor;
import com.company.momento.History;
import com.company.state.Canvas;
import com.company.state.Pencil;
import com.company.state.SelectionTool;

public class Main {

    public static void main(String[] args) {

        //state Pattern
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new Pencil());
        canvas.mouseUp();
        canvas.mouseDown();


        //Momento Pattern
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        System.out.println(editor.getContent());

    }
}
