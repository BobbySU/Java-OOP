package CollectionHierarchy07.ClassImplementation;

import CollectionHierarchy07.Interface.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return super.getItems().remove(super.getItems().size() - 1);
    }

    @Override
    public int add(String element) {
        super.getItems().add(0, element);
        return 0;
    }
}
