package com.company.behaviouralPattern.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private  List<EditorState> states = new ArrayList();

    public void push(EditorState state){
        states.add(state);
    }

    public  EditorState pop(){
        EditorState lastState = null;

        if(states.size() > 0){
            var lastIndex = states.size() - 1;
            lastState = states.get(lastIndex);
            states.remove(lastState);
            return lastState;
        }
        return lastState;

    }

}
