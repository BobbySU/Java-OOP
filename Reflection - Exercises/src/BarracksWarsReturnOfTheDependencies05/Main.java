package BarracksWarsReturnOfTheDependencies05;

import BarracksWarsReturnOfTheDependencies05.core.commands.CommandInterpreterImpl;
import BarracksWarsReturnOfTheDependencies05.interfaces.CommandInterpreter;
import BarracksWarsReturnOfTheDependencies05.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies05.interfaces.Runnable;
import BarracksWarsReturnOfTheDependencies05.interfaces.UnitFactory;
import BarracksWarsReturnOfTheDependencies05.core.Engine;
import BarracksWarsReturnOfTheDependencies05.core.factories.UnitFactoryImpl;
import BarracksWarsReturnOfTheDependencies05.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter interpreter = new CommandInterpreterImpl(repository, unitFactory);
        Runnable engine = new Engine(interpreter);
        engine.run();
    }
}
