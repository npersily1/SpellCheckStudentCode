import java.util.ArrayList;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [Noah Persily]
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {

        int[][] map = new int[26][26];
        int row = dictionary[0].charAt(0) - 'a';
        int col = dictionary[0].charAt(1) - 'a';

        for (int i = 0; i < dictionary.length; i++) {
             if(!(dictionary[i].substring(0,2).equals(dictionary[map[row][col]].substring(0,2)))) {

                row = dictionary[i].charAt(0) - 'a';
                col =  dictionary[i].charAt(1) - 'a';
                map[row][col] = i;

            }
        }
        ArrayList<String> incorrect = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            int start = map[text[i].charAt(0) - 'a'][text[i].charAt(1) - 'a'];
            int end;
            if(text[i].charAt(1) == 'z') {
                 end = map[text[i].charAt(0) - 'a' + 1][0];
            } else   {
                 end =  map[text[i].charAt(0) - 'a'][text[i].charAt(1) - 'a' + 1];
            }
            while(start != end) {

                int middle = (start + end) / 2;
                if(text[i].compareTo(dictionary[middle]) > 0) {
                    end = middle;
                } else if (text[i].compareTo(dictionary[middle]) < 0) {
                    start = middle;
                }
                else {
                    break;
                }


            }
            incorrect.add(text[i]);


        }

        String[] s = new String[incorrect.size()];
        incorrect.toArray(s);
        return null;
    }

}
