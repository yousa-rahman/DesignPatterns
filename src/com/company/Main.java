package com.company;

import com.company.iterator.BrowseHistory;
import com.company.momento.Editor;
import com.company.momento.History;
import com.company.state.Canvas;
import com.company.state.Pencil;

public class Main {

    public static void main(String[] args) {
        iteratorPattern();
//        statePattern();
//        mementoPattern();
    }

    private static void iteratorPattern() {
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator iterator = history.createIterator();
        while(iterator.hasNext()){
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }
    public static void mementoPattern(){
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
    public static void statePattern(){
        //state Pattern
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new Pencil());
        canvas.mouseUp();
        canvas.mouseDown();
    }


}
