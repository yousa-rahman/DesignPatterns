package com.company;

import com.company.command.*;
import com.company.command.editor.BoldCommand;
import com.company.command.editor.HtmlDocument;
import com.company.command.editor.UndoCommand;
import com.company.command.fx.Button;
import com.company.iterator.BrowseHistory;
import com.company.iterator.Iterator;
import com.company.mediator.ArticlesDialogBox;
import com.company.memento.Editor;
import com.company.memento.History;
import com.company.observer.Chart;
import com.company.observer.DataSource;
import com.company.observer.SpreadSheet;
import com.company.state.Canvas;
import com.company.state.Pencil;
import com.company.strategy.BlackAndWhiteFilter;
import com.company.strategy.ImageStorage;
import com.company.strategy.JpegCompressor;
import com.company.strategy.PngCompressor;
import com.company.templateMethod.GenerateReport;
import com.company.templateMethod.Task;
import com.company.templateMethod.TransferMoney;

public class Main {

    public static void main(String[] args) {
        mediatorPattern();

//        observerPattern();
//        undoableCommand();
//        compositeCommand();
//        commandPattern();
//        templateMethod();
//        strategyPattern();
//        iteratorPattern();
//        statePattern();
//        mementoPattern();
    }

    private static void mediatorPattern() {
        ArticlesDialogBox dialog = new ArticlesDialogBox();

        dialog.simulateUserInteraction();

    }

    private static void observerPattern() {
        DataSource source = new DataSource();
        SpreadSheet sheet1 = new SpreadSheet(source);
        SpreadSheet sheet2 = new SpreadSheet(source);
        Chart chart = new Chart(source);

        source.addObserver(sheet1);
        source.addObserver(sheet2);
        source.addObserver(chart);

        source.setValue(10);
    }
    private static void undoableCommand() {
        HtmlDocument document = new HtmlDocument();
        com.company.command.editor.History history = new com.company.command.editor.History();
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
    private static void templateMethod() {

        Task task = new TransferMoney();
        Task report = new GenerateReport();

        task.execute();
        report.execute();
    }
    private static void strategyPattern(){
        ImageStorage imageStorage = new ImageStorage();
        imageStorage.store("FileName", new JpegCompressor(),new BlackAndWhiteFilter());
        imageStorage.store("FileName", new PngCompressor(), new BlackAndWhiteFilter());
    }
    private static void iteratorPattern() {
        BrowseHistory history = new BrowseHistory();
        history.push("a");
        history.push("b");
        history.push("c");

        Iterator iterator = history.createIterator();
        while(iterator.hasNext()){
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }
    public static void mementoPattern(){
        //Momento Pattern
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("a");
        history.push(editor.createState());

        editor.setContent("b");
        history.push(editor.createState());

        editor.setContent("c");
        editor.restore(history.pop());

        System.out.println(editor.getContent());

    }
    public static void statePattern(){
        //state Pattern
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new Pencil());
        canvas.mouseUp();
        canvas.mouseDown();
    }


}
