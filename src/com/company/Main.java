package com.company;

import com.company.behaviouralPattern.chainOfResponsibility.*;
import com.company.behaviouralPattern.command.*;
import com.company.behaviouralPattern.command.editor.BoldCommand;
import com.company.behaviouralPattern.command.editor.HtmlDocument;
import com.company.behaviouralPattern.command.editor.UndoCommand;
import com.company.behaviouralPattern.command.fx.Button;
import com.company.behaviouralPattern.iterator.BrowseHistory;
import com.company.behaviouralPattern.iterator.Iterator;
import com.company.behaviouralPattern.mediator.ArticlesDialogBox;
import com.company.behaviouralPattern.memento.Editor;
import com.company.behaviouralPattern.memento.History;
import com.company.behaviouralPattern.observer.Chart;
import com.company.behaviouralPattern.observer.DataSource;
import com.company.behaviouralPattern.observer.SpreadSheet;
import com.company.behaviouralPattern.state.Canvas;
import com.company.behaviouralPattern.state.Pencil;
import com.company.behaviouralPattern.strategy.BlackAndWhiteFilter;
import com.company.behaviouralPattern.strategy.ImageStorage;
import com.company.behaviouralPattern.strategy.JpegCompressor;
import com.company.behaviouralPattern.strategy.PngCompressor;
import com.company.behaviouralPattern.templateMethod.GenerateReport;
import com.company.behaviouralPattern.templateMethod.Task;
import com.company.behaviouralPattern.templateMethod.TransferMoney;
import com.company.behaviouralPattern.visitor.AnchorNode;
import com.company.behaviouralPattern.visitor.HeadingNode;
import com.company.behaviouralPattern.visitor.HighlightOperation;
import com.company.behaviouralPattern.visitor.PlainTextOperation;
import com.company.structural.composite.Group;
import com.company.structural.composite.Shape;

public class Main {

    public static void main(String[] args) {

        //STRUCTURAL PATTERN
        compositePattern();

        //BEHAVIOURAL PATTERN
       /* visitorPattern();
        chainOfResponsibility();
        mediatorPattern();
        observerPattern();
        undoableCommand();
        compositeCommand();
        commandPattern();
        templateMethod();
        strategyPattern();
        iteratorPattern();
        statePattern();
        mementoPattern(); */
    }

    private static void compositePattern() {
        var group1 = new Group();
        group1.add(new Shape());
        group1.add(new Shape());

        var group2 = new Group();
        group2.add(new Shape());
        group2.add(new Shape());

        var group = new Group();
        group.add(group1);
        group.add(group2);
        group.render();
        group.move();
    }


    //BEHAVIOURAL PATTERN
    private static void visitorPattern() {
        var document = new com.company.behaviouralPattern.visitor.HtmlDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());

        document.execute(new HighlightOperation());
        document.execute(new PlainTextOperation());
    }
    private static void chainOfResponsibility() {
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);

        var webServer = new WebServer(authenticator);
        webServer.handle(new HttpRequest("admin","1234"));
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
    public static void statePattern(){
        //state Pattern
        Canvas canvas = new Canvas();
        canvas.setCurrentTool(new Pencil());
        canvas.mouseUp();
        canvas.mouseDown();
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


}
