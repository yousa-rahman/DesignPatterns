package com.company.state;

public class Pencil implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Pencil Icon");
    }

    @Override
    public void mouseDown() {
        System.out.println("Draw a line");
    }
}
