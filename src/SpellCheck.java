import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 * <p>
 * Completed by: [Noah Persily]
 */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text       The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        return checkWordsTst(text, dictionary);
        //     return checkWordsTrie(text,dictionary);
    }

    public String[] checkWordsTrie(String[] text, String[] dictionary) {


        // Trie for dictionary
        Node root = new Node();
        Trie dict = new Trie(root);

        // Trie for incorrect words
        Node incorrectRoot = new Node();
        Trie incorrect = new Trie(incorrectRoot);

        // ArrayList to be later converted into array to return
        ArrayList<String> incorrectList = new ArrayList<>();


        // Add everyword to the dict
        for (int i = 0; i < dictionary.length; i++) {
            dict.insert(dictionary[i]);
        }

        // For every word
        for (int i = 0; i < text.length; i++) {

            // If it is not in the dictionary
            if (!dict.find(text[i])) {
                // If it is not already in the list of incorrect words.
                if (!incorrect.find(text[i])) {
                    // Add it to the ArrayList
                    incorrectList.add(text[i]);
                    // Add it to the Tri
                    incorrect.insert(text[i]);
                }
            }

        }

        return incorrectList.toArray(new String[incorrectList.size()]);
    }

    public String[] checkWordsTst(String[] text, String[] dictionary) {

        // Initialize the Trie of the dictionary and its root
        TstNode root = new TstNode('l');
        Tst dict = new Tst(root);


        // Insert the dictionary into the TST. Starting from the middle and expanding outwards creates the optimal TST
        int half = dictionary.length / 2;
        dict.insert(dictionary[half]);
        for (int i = 1; i < half; i++) {

            dict.insert(dictionary[half + i]);
            dict.insert(dictionary[half - i]);
        }
        dict.insert(dictionary[0]);

        TstNode incorrectRoot = new TstNode('l');
        Tst incorrect = new Tst(incorrectRoot);
        ArrayList<String> incorrectList = new ArrayList<>();

        // Same process as for a regular trie
        for (int i = 0; i < text.length; i++) {
            if (!dict.find(text[i])) {
                if (!incorrect.find(text[i])) {
                    incorrectList.add(text[i]);
                    incorrect.insert(text[i]);
                }
            }

        }

        return incorrectList.toArray(new String[incorrectList.size()]);

    }

}