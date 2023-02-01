package ListsAndCollections;

import java.util.*;

public class _ArrayList {
    public static void main(String[] args) {

        // ArrayList<String> cities = new ArrayList<>();

        /**
         * ArrayList is backed by the Array
         * > whenever size is expected to exceed capacity, we resize by
         * setting the field equal to a new array
         * > more effiecient at retrieving elements
         * 
         * LinkedList is a Chain of Nodes
         * > references to previous and next in line nodes are using to
         * traverse the list
         * > more efficient at adding/removing elements from the middle
         * of the list
         */

        /**
         * Showing polymorphism
         */
        List<String> cities = new LinkedList<>();
        List<Integer> cityNum = new ArrayList<>();

        cities.add("Paris");
        cities.add("Florence");
        cities.add("Venice");
        cities.add("Versailles");
        System.out.println(cities.size());
        cities.add("London");
        cities.add("Petra");
        cities.add("Oslo");
        System.out.println(cities.size());
        cities.add("Rome");
        cities.add("Madrid");
        cities.add("Tokyo");
        System.out.println(cities.size());
        cities.add("Prague");
        cities.add("Dublin");
        System.out.println(cities.size());
        cities.add("Athens");
        cities.add("Marseille");
        cities.add("Chicago");

        System.out.println(cities.get(5));
        System.out.println(cities.get(8));
        cities.set(2, "Naples");
        cities.remove(5);

        System.out.println(cities.size());
        System.out.println(cities.get(5));
        System.out.println(cities.get(8));

    }
}
