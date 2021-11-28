package BarracksWarsTheCommandsStrikeBack04;

import BarracksWarsTheCommandsStrikeBack04.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack04.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack04.interfaces.UnitFactory;
import BarracksWarsTheCommandsStrikeBack04.core.Engine;
import BarracksWarsTheCommandsStrikeBack04.core.factories.UnitFactoryImpl;
import BarracksWarsTheCommandsStrikeBack04.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
