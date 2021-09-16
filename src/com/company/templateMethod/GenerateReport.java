package com.company.templateMethod;

public class GenerateReport extends Task{
    @Override
    protected void doExecute() {
        System.out.println("Report Generated");
    }
}
