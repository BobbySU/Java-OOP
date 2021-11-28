package BarracksWarsANewFactory03.core.factories;

import BarracksWarsANewFactory03.interfaces.Unit;
import BarracksWarsANewFactory03.interfaces.UnitFactory;
import BarracksWarsANewFactory03.models.units.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"BarracksWarsANewFactory03.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 3
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME+unitType);
			Constructor<Unit> unitConstructor= unitClass.getDeclaredConstructor();
			return unitConstructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
				| IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
