package CollectionHierarchy07;

import CollectionHierarchy07.ClassImplementation.AddCollection;
import CollectionHierarchy07.ClassImplementation.AddRemoveCollection;
import CollectionHierarchy07.ClassImplementation.MyListImpl;
import CollectionHierarchy07.Interface.AddRemovable;
import CollectionHierarchy07.Interface.Addable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] input = scan.nextLine().split(" ");
        int countRemove = Integer.parseInt(scan.nextLine());

        printAdd(input, addCollection);
        printAdd(input, addRemoveCollection);
        printAdd(input, myList);

        printRemove(countRemove, addRemoveCollection);
        printRemove(countRemove, myList);
    }

    private static void printRemove(int countRemove, AddRemovable collection) {
        for (int i = 0; i < countRemove; i++) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }

    private static void printAdd(String[] input, Addable collection) {
        for (String text : input) {
            System.out.print(collection.add(text) + " ");
        }
        System.out.println();
    }
}
