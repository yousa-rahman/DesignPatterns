package com.company.behaviouralPattern.command;

import com.company.behaviouralPattern.command.editor.BoldCommand;
import com.company.behaviouralPattern.command.editor.HtmlDocument;
import com.company.behaviouralPattern.command.editor.UndoCommand;
import com.company.behaviouralPattern.command.fx.Button;

public class Main {

    public static void main(String[] args) {
//        undoableCommand();
        compositeCommand();
//        commandPattern();
    }

    private static void undoableCommand() {
        HtmlDocument document = new HtmlDocument();
        com.company.behaviouralPattern.command.editor.History history = new com.company.behaviouralPattern.command.editor.History();
        document.setContent("Hello World");

        BoldCommand boldCommand = new BoldCommand(document, history);
        boldCommand.execute();
        System.out.println(document.getContent());

        var undoCommand = new UndoCommand(history);
        undoCommand.execute();
        System.out.println(document.getContent());

    }
    private static void compositeCommand() {
        CompositeCommand compositeCommand = new CompositeCommand();

        compositeCommand.add(new ResizeCommand());
        compositeCommand.add(new BlackAndWhiteCommand());
        compositeCommand.execute();
        compositeCommand.execute();
    }
    private static void commandPattern() {
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
