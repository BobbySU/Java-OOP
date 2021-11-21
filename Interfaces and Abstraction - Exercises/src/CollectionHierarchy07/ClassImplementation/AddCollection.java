package CollectionHierarchy07.ClassImplementation;

import CollectionHierarchy07.Interface.Addable;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String element) {
        super.getItems().add(element);
        return super.getItems().indexOf(element);
    }
}
