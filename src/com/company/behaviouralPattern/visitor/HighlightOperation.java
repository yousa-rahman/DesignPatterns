package com.company.behaviouralPattern.visitor;

public class HighlightOperation implements Operation{
    @Override
    public void apply(AnchorNode node) {
        System.out.println("Highlighting - Anchor");
    }

    @Override
    public void apply(HeadingNode node) {
        System.out.println("Highlighting - Heading");
    }
}
