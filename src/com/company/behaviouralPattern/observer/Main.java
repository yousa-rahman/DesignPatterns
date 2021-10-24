package com.company.behaviouralPattern.observer;

public class Main {

    public static void main(String[] args) {
        DataSource source = new DataSource();
        SpreadSheet sheet1 = new SpreadSheet(source);
        SpreadSheet sheet2 = new SpreadSheet(source);
        Chart chart = new Chart(source);

        source.addObserver(sheet1);
        source.addObserver(sheet2);
        source.addObserver(chart);

        source.setValue(10);
    }
}
