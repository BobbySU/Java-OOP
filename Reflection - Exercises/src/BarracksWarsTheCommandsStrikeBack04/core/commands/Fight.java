package BarracksWarsTheCommandsStrikeBack04.core.commands;

import BarracksWarsTheCommandsStrikeBack04.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack04.interfaces.UnitFactory;

public class Fight extends Command{
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
