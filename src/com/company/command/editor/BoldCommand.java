package com.company.command.editor;

public class BoldCommand implements UndoableCommand{
    private String prevContent;
    private HtmlDocument document;
    private History history;

    public BoldCommand(HtmlDocument document, History history) {
        this.document = document;
        this.history = history;
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.bold();
        history.push(this);
    }

    @Override
    public void unExecute() {
        document.setContent(prevContent);
    }
}
