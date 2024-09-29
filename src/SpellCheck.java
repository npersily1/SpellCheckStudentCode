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

        int[][] map = new int[26][26];

        int row = dictionary[0].charAt(0) - 'a';
        int col = dictionary[0].charAt(1) - 'a';

        int firstword = col ;

        for (int i = 0; i < dictionary.length; i++) {
            if (!(dictionary[i].substring(0, 2).equals(dictionary[map[row][col]].substring(0, 2)))) {

                row = dictionary[i].charAt(0) - 'a';
                col = dictionary[i].charAt(1) - 'a';
                map[row][col] = i;

            }

        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if(map[i][j] == 0) {
                    map[i][j] = -1;
                }
            }
        }
        map[0][firstword] = 0;
        ArrayList<String> incorrect = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {


            int first = text[i].charAt(0) - 'a';
            int second = text[i].charAt(1) - 'a';

            if (map[first][second] == -1) {
                incorrect.add(text[i]);
                continue;
            }

            int start = map[first][second];
            int end = 0;
            for (int j = 1 + second; j < 26; j++) {
                if (map[first][j] >= 0) {
                    end = map[first][j];
                    break;
                }
            }
            boolean doubleBreak = false;
            if (end == 0) {
                for (int j = first + 1; j < 26; j++) {
                    for (int k = 0; k < 26; k++) {
                        if (map[j][k] >= 0) {
                            end = map[j][k];
                            doubleBreak = true;
                            break;
                        }
                    }
                    if (doubleBreak){
                        break;
                    }
                }
            }
            boolean isCorrect = false;

            while (start <= end) {

                int middle = (start + end) / 2;
                if(text[i].compareTo(dictionary[middle]) == 0) {
                    isCorrect = true;
                    break;
                }
                else if (text[i].compareTo(dictionary[middle]) > 0) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }


            }
            if (!isCorrect) {
                incorrect.add(text[i]);
            }
        }

        String[] s = new String[incorrect.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = incorrect.get(i);
        }
        return s;
    }

}
