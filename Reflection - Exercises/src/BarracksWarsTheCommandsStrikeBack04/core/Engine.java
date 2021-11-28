package BarracksWarsTheCommandsStrikeBack04.core;

import BarracksWarsTheCommandsStrikeBack04.core.commands.Command;
import BarracksWarsTheCommandsStrikeBack04.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack04.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack04.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine implements Runnable {
    private static String COMMAND_PATH_NAME = "BarracksWarsTheCommandsStrikeBack04.core.commands.";
    private static String EXECUTE_METHOD_NAME = "execute";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) {
        String result = "";
        try {
            String commandClassName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);
            Class clazz = Class.forName(COMMAND_PATH_NAME + commandClassName);
            Constructor<Command> commandConstructor = clazz.getDeclaredConstructor(String[].class,
                    Repository.class, UnitFactory.class);
            Command commandInstance = commandConstructor.newInstance(data, this.repository, this.unitFactory);
            Method executeMethod = clazz.getDeclaredMethod(EXECUTE_METHOD_NAME);
            try {
                result = (String) executeMethod.invoke(commandInstance);
            }catch (InvocationTargetException e){
                System.out.print(e.getCause().getMessage());
            }


        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
