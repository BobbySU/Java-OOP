package BarracksWarsANewFactory03;

import BarracksWarsANewFactory03.interfaces.Repository;
import BarracksWarsANewFactory03.interfaces.Runnable;
import BarracksWarsANewFactory03.interfaces.UnitFactory;
import BarracksWarsANewFactory03.core.Engine;
import BarracksWarsANewFactory03.core.factories.UnitFactoryImpl;
import BarracksWarsANewFactory03.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
