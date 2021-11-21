package CollectionHierarchy07.ClassImplementation;

import CollectionHierarchy07.Interface.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        return super.getItems().remove(0);
    }

    @Override
    public int add(String element) {
        super.getItems().add(0, element);
        return 0;
    }
}
