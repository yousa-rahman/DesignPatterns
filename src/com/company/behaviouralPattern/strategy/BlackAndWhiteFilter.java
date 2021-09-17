package com.company.behaviouralPattern.strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(String fileName) {
        System.out.println("Applying Black And White Filter");
    }
}
