package BarracksWarsReturnOfTheDependencies05.core.commands;

import BarracksWarsReturnOfTheDependencies05.anotation.Inject;
import BarracksWarsReturnOfTheDependencies05.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies05.interfaces.Unit;
import BarracksWarsReturnOfTheDependencies05.interfaces.UnitFactory;

public class Add extends Command {
    public Add(String[] data) {
        super(data);
    }

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
