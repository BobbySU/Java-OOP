package BarracksWarsReturnOfTheDependencies05.core.commands;

import BarracksWarsReturnOfTheDependencies05.interfaces.CommandInterpreter;
import BarracksWarsReturnOfTheDependencies05.interfaces.Executable;
import BarracksWarsReturnOfTheDependencies05.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies05.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME = "BarracksWarsReturnOfTheDependencies05.core.commands.";
    private static final String EXECUTE_METHOD_NAME = "execute";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String interpretCommand(String[] data, String commandName) {
        String result = "";
        try {
            String commandClassName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
            Class clazz = Class.forName(COMMANDS_PACKAGE_NAME + commandClassName);
            Constructor<Command> commandConstructor = clazz.getDeclaredConstructor(String[].class);
            Command commandInstance = commandConstructor.newInstance((Object) data);
            injectsField(commandInstance);
            Method executeMethod = clazz.getDeclaredMethod(EXECUTE_METHOD_NAME);
            try {
                result = (String) executeMethod.invoke(commandInstance);
            } catch (InvocationTargetException e) {
                System.out.print(e.getCause().getMessage());
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void injectsField(Executable executable) {

        Field[] declaredField = executable.getClass().getDeclaredFields();
        Field[] declaredFields = this.getClass().getDeclaredFields();

        for (Field exField : declaredField) {
            if (exField.getAnnotations()[0].toString().contains("Inject")) {
                for (Field curField : declaredFields) {
                    if (curField.getType().equals(exField.getType())) {
                        exField.setAccessible(true);
                        try {
                            exField.set(executable, curField.get(this));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
