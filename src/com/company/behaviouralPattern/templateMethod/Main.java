package com.company.behaviouralPattern.templateMethod;

public class Main {

    public static void main(String[] args) {
        Task task = new TransferMoney();
        Task report = new GenerateReport();

        task.execute();
        report.execute();
    }
}
