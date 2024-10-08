public class Tst {
    TstNode root;

    public Tst(TstNode r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    public void insert(String s, TstNode n, int length) {
        // If a null node

        if (n == null) {
            // Create a new node with the first letter
            n = new TstNode(s.charAt(0));
            // Create a straight chain of nodes and set the last to be true
            creatChain(s.substring(1), n).setWord(true);
            return;
        }
        if (length == 0) {
            n.setWord(true);
            return;
        }

        if (s.charAt(0) > n.getLetter()) {
            insert(s, n.getGreaterThan(), length);
        } else if (s.charAt(0) == n.getLetter()) {
            insert(s.substring(1), n.getEquals(), length - 1);
        } else {
            insert(s, n.getLessThan(), length);
        }
    }

    private TstNode creatChain(String s, TstNode n) {
        if (s.equals("")) {
            return n;
        }
        n.setEquals(new TstNode(s.charAt(0)));
        return creatChain(s.substring(1), n.getEquals());

    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    public boolean find(String s, TstNode n, int length) {
        // If your word is at outside the tree
        if (n == null) {
            return false;
        }
        // If you have reached the end and found a word
        if (length == 0 && n.isWord()) {
            return true;
        }
        // If you have reached the end of the word, but it is not in the tree. (The case where I have chomp in the tree and I put "cho" as a word
        if (length == 0) {
            return false;
        }


        if (s.charAt(0) > n.getLetter()) {
            return find(s, n.getGreaterThan(), length);
        }
        else if (s.charAt(0) == n.getLetter()) {
            return find(s.substring(1), n.getEquals(), length - 1);
        }
        else {
            return find(s, n.getLessThan(), length);
        }
    }

}
