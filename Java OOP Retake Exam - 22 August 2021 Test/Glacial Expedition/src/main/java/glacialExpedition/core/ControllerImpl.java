package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.List;

import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int explored;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.explored = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

//        Collection<String> stateExhibits = state.getExhibits();
//        Collections.addAll(stateExhibits,exhibits);
        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
        }

        this.stateRepository.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);
        if (explorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> explorerList = this.explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50).collect(Collectors.toList());
        if (explorerList.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State stateToExplore = this.stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(stateToExplore, explorerList);
        long retire = explorerList.stream().filter(e -> e.getEnergy() == 0).count();
        this.explored++;
        return String.format(STATE_EXPLORER, stateName, retire);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(FINAL_STATE_EXPLORED, this.explored));
        result.append(System.lineSeparator());
        result.append(FINAL_EXPLORER_INFO);

        Collection<Explorer> explorerCollector = this.explorerRepository.getCollection();
        for (Explorer e : explorerCollector) {
            result.append(System.lineSeparator());
            result.append(String.format(FINAL_EXPLORER_NAME, e.getName()));
            result.append(System.lineSeparator());
            result.append(String.format(FINAL_EXPLORER_ENERGY, e.getEnergy()));
            result.append(System.lineSeparator());
            if (e.getSuitcase().getExhibits().isEmpty()) {
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                result.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, e.getSuitcase().getExhibits())));
            }
        }
        return result.toString();
    }
}
