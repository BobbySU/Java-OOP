package BarracksWarsTheCommandsStrikeBack04.core.commands;

import BarracksWarsTheCommandsStrikeBack04.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack04.interfaces.Unit;
import BarracksWarsTheCommandsStrikeBack04.interfaces.UnitFactory;

public class Add extends Command{
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
