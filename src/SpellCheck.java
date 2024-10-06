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

        return checkWordsTst(text,dictionary);
    }
    public String[] checkWordsTrie(String[] text, String[] dictionary) {
        Node root = new Node();
        Trie dict = new Trie(root);

        Node incorrectRoot = new Node();
        Trie incorrect = new Trie(incorrectRoot);

        ArrayList<String> incorrectList = new ArrayList<>();

        for (int i = 0; i < dictionary.length; i++) {
            dict.insert(dictionary[i]);
        }
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
    public String[] checkWordsTst(String[] text, String[] dictionary) {

        TstNode root = new TstNode('m');
        Tst dict = new Tst(root);
        ArrayList<String> incorrectList = new ArrayList<>();

        dict.insert(dictionary[dictionary.length/2]);

        for (int i = 0; i < dictionary.length; i++) {
            dict.insert(dictionary[i]);
        }

        TstNode incorrectRoot = new TstNode('m');
        Tst incorrect = new Tst(incorrectRoot);

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