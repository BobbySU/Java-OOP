package BarracksWarsReturnOfTheDependencies05.core.commands;

import BarracksWarsReturnOfTheDependencies05.anotation.Inject;
import BarracksWarsReturnOfTheDependencies05.interfaces.Repository;

public class Retire extends Command {
    public Retire(String[] data) {
        super(data);
    }

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String unitType = getData()[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
