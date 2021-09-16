package com.company.command;

import com.company.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Applying Black And White Filter");
    }
}
