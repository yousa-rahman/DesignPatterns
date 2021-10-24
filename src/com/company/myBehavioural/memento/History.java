package com.company.myBehavioural.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    List<ArticleState> state = new ArrayList<>();

    public void push(ArticleState state){
        this.state.add(state);
    }

    public ArticleState pop(){

        int lastIndex = state.size() - 1;
        ArticleState lastState = state.get(lastIndex);
        state.remove(lastState);
        return lastState;
    }
}
