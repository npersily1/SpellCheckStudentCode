public class Trie {
    private Node root;

    public Trie(Node r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    private void insert(String s, Node node, int size) {

        if (node.getChildren()[s.charAt(0)] == null) {
            node.getChildren()[s.charAt(0)] = new Node();
        }
        if (size == 1) {

            node.getChildren()[s.charAt(0)].setWord(true);
            return;
        }
        insert(s.substring(1), node.getChildren()[s.charAt(0)], size - 1);
    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    private boolean find(String s, Node node, int size) {

        if (node.getChildren()[s.charAt(0)] == null) {
            return false;
        }
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
