import java.util.ArrayList;

public class Trie {
    private Node root;

    public Trie(Node r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    private void insert(String s, Node root, int size) {
        if (size == 1) {
            root.getChildren()[s.charAt(0)] = new Node();
            root.getChildren()[s.charAt(0)].setWord(true);
            return;
        }
        if (root.getChildren()[s.charAt(0)] == null) {
            root.getChildren()[s.charAt(0)] = new Node();
        }
        insert(s.substring(1), root.getChildren()[s.charAt(0)], size - 1);
    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    private boolean find(String s, Node root, int size) {

        if (root.getChildren()[s.charAt(0)] == null) {
            return false;
        }
        if (s.length() == 1) {
            if (root.getChildren()[s.charAt(0)].isWord()) {
                return true;
            } else {
                return false;
            }
        }
        return find(s.substring(1), root.getChildren()[s.charAt(0)], size - 1);
    }
}
