package invertedindex;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
 * Class to build an index.
 */
public class InvertedIndex {
    // Properties
    //private BinarySearchTreeMap<String, List<File>> index;
    private Map<String, List<File>> index;

    private Set<String> allWords;  //set of all unique words in the index
    //used in profiling the search method

    // Methods
    public InvertedIndex() {
        //index = new BinarySearchTreeMap<>();
        index = new TreeMap<>(); // Use HashMap in a separate run

        allWords = new HashSet();
    }

    public void buildIndex(List<File> files) {
        for (File file : files) {
            try {
                Scanner in = new Scanner(file);

                String line;
                String words[];

                while (in.hasNextLine()) {
                    //read a line
                    line = in.nextLine();
                    // parse line into words
                    // the character pattern that separates words is any sequence of
                    // characters other than letters, numbers and apostrophe
                    // This strips off punctuation marks
                    words = line.split("[^A-Za-z0-9']+");

                    //add words and filename to index
                    for (String word : words) {
                        if (!word.equals("")) {
                            if (!index.containsKey(word)) {
                                List<File> list = new ArrayList();
                                list.add(file);
                                index.put(word, list);
                                allWords.add(word);
                            } else {
                                // word already in index - check if fileName there
                                List<File> list = index.get(word);
                                if (!list.contains(file)) {
                                    list.add(file);
                                }
                            }
                        }
                    }
                }

            } catch (IOException exc) {
                System.out.println("File does not exist");
                exc.printStackTrace();
                System.exit(1);
            }
        }
    }
    
    public void print() {
        // Print all keys and values in the map
        Set<String> keySet = index.keySet();
        for (String key : keySet) {
            List<File> value = index.get(key);
            System.out.println(key + " : " + value);
        }
    }

    public List<File> search(String s) {
        List<File> value = index.get(s);
        return value;
    }

    public List<File> searchs1NOTs2(String s1, String s2){
        List<File> files = index.get(s1);
        List<File> notFiles = index.get(s2);
        List<File> values = new LinkedList<>();

            for (File f:
                 files) {
                if (!notFiles.contains(f)){
                    values.add(f);
                }
            }
        return values;
    }

    //method to profile search: call search method with all words in inverted index 
    public void searchAllWords() {
        int reps = 1000; // increase this if necessary
        for (int i = 1; i < reps; i++)

            for (String s : allWords) {
                search(s);
            }
    }
}