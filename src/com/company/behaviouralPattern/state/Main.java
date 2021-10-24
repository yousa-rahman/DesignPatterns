package com.company.behaviouralPattern.state;

public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new Pencil());
        canvas.mouseUp();
        canvas.mouseDown();
    }
}
