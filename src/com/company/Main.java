package com.company;

import com.company.iterator.BrowseHistory;
import com.company.iterator.Iterator;
import com.company.momento.Editor;
import com.company.momento.History;
import com.company.state.Canvas;
import com.company.state.Pencil;
import com.company.strategy.BlackAndWhiteFilter;
import com.company.strategy.ImageStorage;
import com.company.strategy.JpegCompressor;
import com.company.strategy.PngCompressor;
import com.company.templateMethod.AuditTrail;
import com.company.templateMethod.GenerateReport;
import com.company.templateMethod.Task;
import com.company.templateMethod.TransferMoney;

public class Main {

    public static void main(String[] args) {

        templateMethod();
//        strategyPattern();
//        iteratorPattern();
//        statePattern();
//        mementoPattern();
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
