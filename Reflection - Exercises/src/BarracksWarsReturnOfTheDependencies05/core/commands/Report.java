package BarracksWarsReturnOfTheDependencies05.core.commands;

import BarracksWarsReturnOfTheDependencies05.anotation.Inject;
import BarracksWarsReturnOfTheDependencies05.interfaces.Repository;

public class Report extends Command {
    public Report(String[] data) {
        super(data);
    }

    @Inject
    private Repository repository;

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
