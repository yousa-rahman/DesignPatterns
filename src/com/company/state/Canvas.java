package com.company.state;

public class Canvas {
    private Tool currentTool;

    public void mouseUp(){
        currentTool.mouseUp();
    }

    public void mouseDown(){
        currentTool.mouseDown();
    }

    public void setCurrentTool(Tool currentTool) {
        this.currentTool = currentTool;
    }

    public Tool getCurrentTool() {
        return currentTool;
    }
}
