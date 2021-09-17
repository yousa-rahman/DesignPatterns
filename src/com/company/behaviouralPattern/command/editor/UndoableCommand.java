package com.company.behaviouralPattern.command.editor;

public interface UndoableCommand extends Command{
    void unExecute();
}
