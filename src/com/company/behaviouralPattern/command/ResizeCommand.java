package com.company.behaviouralPattern.command;

import com.company.behaviouralPattern.command.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize the Object");
    }
}
