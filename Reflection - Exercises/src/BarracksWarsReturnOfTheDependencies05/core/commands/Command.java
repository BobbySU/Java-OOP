package BarracksWarsReturnOfTheDependencies05.core.commands;

import BarracksWarsReturnOfTheDependencies05.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }
}
