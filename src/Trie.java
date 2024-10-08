public class Trie {
    private Node root;

    public Trie(Node r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    private void insert(String s, Node node, int size) {
        // If we are adventuring to a new node, create it
        if (node.getChildren()[s.charAt(0)] == null) {
            node.getChildren()[s.charAt(0)] = new Node();
        }
        // If at the end of the words set it to a new word
        if (size == 1) {
            node.getChildren()[s.charAt(0)].setWord(true);
            return;
        }
        // Recurse on the islands connected to the current letter then change letter to the next
        insert(s.substring(1), node.getChildren()[s.charAt(0)], size - 1);
    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    private boolean find(String s, Node node, int size) {

        // If the word is not in the tree
        if (node.getChildren()[s.charAt(0)] == null) {
            return false;
        }
        // If the word is in tree but is not defined as an actual word.
        // For example the word "cho" isn't a word, but it appears in the tree throught the word"chomp"
        if (size == 1) {
            if (node.getChildren()[s.charAt(0)].isWord()) {
                return true;
            } else {
                return false;
            }
        }
        return find(s.substring(1), node.getChildren()[s.charAt(0)], size - 1);
    }
}
