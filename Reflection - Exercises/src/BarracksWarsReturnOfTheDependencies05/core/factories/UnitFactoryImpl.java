package BarracksWarsReturnOfTheDependencies05.core.factories;

import BarracksWarsReturnOfTheDependencies05.interfaces.Unit;
import BarracksWarsReturnOfTheDependencies05.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"BarracksWarsReturnOfTheDependencies05.models.units.";

	@Override
	public Unit createUnit(String unitType) {
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
