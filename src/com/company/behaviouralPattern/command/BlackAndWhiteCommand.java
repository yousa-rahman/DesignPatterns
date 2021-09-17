package com.company.behaviouralPattern.command;

import com.company.behaviouralPattern.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Applying Black And White Filter");
    }
}
