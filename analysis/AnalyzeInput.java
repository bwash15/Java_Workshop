package analysis;

import java.util.*;

import javax.xml.crypto.Data;

import java.io.Console;

class SortByValue implements Comparator<DataPoint> {
    public int compare(DataPoint a, DataPoint b) {
        return a.value - b.value;
    }
}

class DataPoint {
    String key = "";
    Integer value = 0;
    PointInTime pointInTime;

    DataPoint(String s, Integer i) {
        key = s;
        value = i;
        pointInTime = new PointInTime();
    }
}

public class AnalyzeInput {

    /**
     * REFACTOR:
     * > Frequency should be returned from method
     * 
     */

    public static void main(String[] args) {
        Console cons = null;
        ArrayList<String> text = new ArrayList<>();
        List<DataPoint> frequencies = new ArrayList<>();
        DataPoint dataPoint;
        Set<String> textSet = new HashSet<>();
        Map<String, Integer> mapOfText = new HashMap<>();
        TreeMap<String, Integer> treeMapOfText = new TreeMap<>();
        char[] letters = null;

        int freqOfWord = 0;

        String line = "";
        Boolean running = true;

        // Command-Line Entry
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {

                System.out.print("CLI Args: ");
                System.out.println(i + " " + args[i]);
                text.add(args[i]);
            }
        } else {
            System.out.println("No CLI Args Found, starting program...");
            System.out.print("@ > ");
        }

        // Extracting the Unique Elements > adding list to the Set
        // Set will remove duplicate data
        textSet.addAll(text);
        // Program Running Entries
        while (running) {
            cons = System.console();
            line = cons.readLine();
            if (!line.equals("*") && cons != null && line != null) {

                // EDA - Preparing data
                // Creating SET
                text = convertSplitTextToList(line, text);
                textSet = copyToSet(text, textSet);

                // Separating word into letters
                letters = separateIntoChar(line, letters);

                // Starting Analysis
                // getFrequency(textSet, text, freqOfWord, mapOfText);
                Iterator iter = textSet.iterator();
                while (iter.hasNext()) {
                    // point to the next element in the list
                    String s = (String) iter.next();
                    freqOfWord = Collections.frequency(text, s);
                    System.out.println(" [" + s + "] appears " + freqOfWord + " times");
                    mapOfText = putIntoMap(s, freqOfWord);
                    treeMapOfText = putIntoTreeMap(s, freqOfWord);
                    dataPoint = new DataPoint(s, freqOfWord);
                    frequencies.add(dataPoint);
                }

                Collections.sort(frequencies, Collections.reverseOrder(new SortByValue()));

                System.out.print(" -- Sorted results -- \n");

                for (int i = 0; i < frequencies.size(); i++)
                    System.out.println(
                            "\n[" + frequencies.get(i).value + "] time(s) for word - ["
                                    + frequencies.get(i).key + "]\n"
                                    + frequencies.get(i).pointInTime.toString());

                System.out.println("==============================================");
                // counting all the words in the mapOfText with size()
                for (int index = 0; index < frequencies.size(); index++) {
                    System.out.println("Frequencies: " + frequencies.get(index).value);
                }
                System.out.println("==============================================");
                System.out.println("Word Count in List of Frequencies: " + frequencies.size() + " so far...");
                System.out.println("Word Count: " + text.size() + " so far...");
                System.out.println("==============================================");
                System.out.println("==============================================");

                System.out.println("==============================================");
                // counting all the words in the mapOfText with size()
                System.out.println("Map of Entries Made: " + mapOfText);
                System.out.println("==============================================");
                System.out.println("Word Count in HashMap: " + mapOfText.size() + " so far...");
                System.out.println("Word Count: " + text.size() + " so far...");
                System.out.println("==============================================");
                System.out.println("==============================================");

                // counting all the words in the treeMapOftext with size()
                System.out.println("TreeMap of Entries Made: " + treeMapOfText);
                System.out.println("==============================================");
                System.out.println("Word Count in Tree Map: " + treeMapOfText.size() + " so far...");
                System.out.println("Word Count: " + text.size() + " so far...");
                System.out.println("==============================================");

                // Prompting for new entry
                System.out.print("@ > ");

                // System.out.println("Separating Words into Characters for further
                // analysis...");
                // // Separating words into char[]
                // letters = separateIntoChar(word, letters);

                // printCharacters(letters);

            } else {
                running = false;
                System.out.println("End of program symbol read [*], ending program...");
            }
        }
        System.out.println("Input Analyzed: " + text);
        System.out.println("Total Word Count: " + text.size());

    }

    /**
     * > The function takes a string and a list as parameters, and adds the string
     * to the list
     * 
     * @param line The line of text to be added to the list
     * @param text The list of words to be added to
     * @return A string
     */
    public static ArrayList<String> convertSplitTextToList(String line, ArrayList<String> text) {
        // By default adds to the end of the list
        // > text.add(line); - Generated an infinite loop

        // First, turn the whole of the text into a list
        // Creates a new list Each iteration
        List<String> listOfLines = new ArrayList<>(Arrays.asList(line.split(" ")));
        text.addAll(listOfLines);

        return text;
    }

    /**
     * It takes a string and returns an array of characters
     * 
     * @param word    The word that the user has entered.
     * @param letters the array that will be returned
     * @return The method is returning the array of characters.
     */
    public static char[] separateIntoChar(String word, char[] letters) {

        return letters = word.toCharArray();
    }

    /**
     * FuncName: getFrequency
     * This function takes a list of strings, an integer, a string, and a map as
     * parameters. It creates a
     * set of strings, adds the list of strings to the set, creates an iterator,
     * iterates through the set,
     * and prints the frequency of each string in the set
     * 
     * @param linesList (List<String>) - the list of lines from the text file
     * @param freq      (int) - the frequency of the word > Passed by Value
     * @param s         (String) > Passed by Value
     * @param map       (Map) - a map of the text
     * @param iter      (Iterator) - built from the textSet in Main
     */
    public static void getFrequency(Set<String> textSet, ArrayList<String> linesList, int freq,
            Map<String, Integer> map) {

        Iterator iter = textSet.iterator();
        while (iter.hasNext()) {
            // point to the next element in the list
            String s = (String) iter.next();
            freq = Collections.frequency(linesList, s);
            map = putIntoMap(s, freq);
        }
    }

    /**
     * It takes a list of strings and adds them to a set
     * 
     * @param linesList a list of strings
     * @param textSet   The set to copy the lines to.
     * @return A boolean value.
     */

    public static Set<String> copyToSet(List<String> linesList, Set<String> textSet) {

        // putting in a for loop to iterate the list and copy each element
        for (String string : linesList) {
            if (!textSet.contains(string))
                textSet.add(string);
        }
        return textSet;

    }

    /**
     * This function takes a list of strings, an integer, a string, and a treemap as
     * parameters. It then
     * creates a set of strings, adds all the strings from the list to the set, and
     * then iterates through
     * the set. It then points to the next element in the list, sets the string to
     * the next element in the
     * list, and sets the frequency to the frequency of the string in the list. It
     * then prints out the
     * string and the frequency, and then adds the string and the frequency to the
     * treemap. It then prints
     * out the treemap
     * 
     * @param linesList (List<String>) - the list of lines from the text file
     * @param freq      (int) - the frequency of the word in the text > Passed by
     *                  Value
     * @param s         (String) - > Passed by value
     * @param treeMap   (treeMap) - the TreeMap that will be used to store the words
     *                  and their
     *                  frequencies
     */
    public static void getTreeMapFrequency(Set<String> textSet, ArrayList<String> linesList, int freq,
            TreeMap<String, Integer> treeMap) {

        Iterator iter = textSet.iterator();
        while (iter.hasNext()) {
            // point to the next element in the list
            String s = (String) iter.next();
            freq = Collections.frequency(linesList, s);
            treeMap = putIntoTreeMap(s, freq);
            System.out.println("\tMap of Text: " + treeMap);
        }
    }

    /**
     * Create a new TreeMap, put the given key and value into it, and return it.
     * 
     * @param s    the string to be added to the tree
     * @param freq the frequency of the word
     * @return A TreeMap with a single key-value pair.
     */
    public static TreeMap<String, Integer> putIntoTreeMap(String s, int freq) {
        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put(s, freq);
        return tree;
    }

    /**
     * This function takes a string and an integer and returns a map with the string
     * as the key and the
     * integer as the value.
     * 
     * @param s    the string to be added to the map
     * @param freq the frequency of the word in the corpus.
     * @return A map with a single key-value pair.
     */
    public static Map<String, Integer> putIntoMap(String s, int freq) {
        Map<String, Integer> _map = new HashMap<>();
        _map.put(s, freq);
        return _map;
    }

    /**
     * PrintFreqInfo prints a string and its frequency.
     * 
     * @param s    the string to print
     * @param freq the number of times the word appears in the text
     */
    public static void printFreqInfo(String s, int freq) {
        System.out.println("==============================================");
        System.out.println(s + " appears " + freq + " times");
        System.out.println("==============================================");
    }

    /**
     * Prints all the characters in the array letters.
     * 
     * @param letters the array of characters to print
     */
    public static void printCharacters(char[] letters) {
        for (int i = 0; i < letters.length; i++) {
            System.out.println(" [" + i + ". " + letters[i] + "]");
        }
    }

}
