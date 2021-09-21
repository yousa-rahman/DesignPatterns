package com.company.behaviouralPattern.visitor;

public interface Operation {
    void apply(AnchorNode node);
    void apply(HeadingNode node);
}
