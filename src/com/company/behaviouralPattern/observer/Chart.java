package com.company.behaviouralPattern.observer;

public class Chart implements Observer{
    private DataSource dataSource;

    public Chart(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        System.out.println("Chart Updated: " + dataSource.getValue());
    }
}
