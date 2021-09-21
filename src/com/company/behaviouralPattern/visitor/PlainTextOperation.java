package com.company.behaviouralPattern.visitor;

public class PlainTextOperation implements Operation {
    @Override
    public void apply(AnchorNode node) {
        System.out.println("PlainText - Anchor");
    }

    @Override
    public void apply(HeadingNode node) {
        System.out.println("PlainText - Heading");
    }
}
