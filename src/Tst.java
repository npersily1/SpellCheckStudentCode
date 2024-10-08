public class Tst {
    TstNode root;

    public Tst(TstNode r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    private void insert(String s, TstNode n, int length) {
        // If the current letter is the same as the current node's letter
        if (s.charAt(0) == n.getLetter()) {
            if (length == 1) {
                n.setWord(true);
                return;
            }
            // If next node we want to go to is null, create a node with the next letter
            if (n.getEquals() == null) {
                n.setEquals(new TstNode(s.charAt(1)));
            }
            // Recurse with the first letter chopped off, the next node, and the new length
            insert(s.substring(1), n.getEquals(), length - 1);
            // These two conditional bodies of code do basically the same as what is above.
            // Except, They don't change the word or length because they don't accept the letter
        } else if (s.charAt(0) > n.getLetter()) {
            if (n.getGreaterThan() == null) {
                n.setGreaterThan(new TstNode(s.charAt(0)));
            }
            insert(s, n.getGreaterThan(), length);

        } else {
            if (n.getLessThan() == null) {
                n.setLessThan(new TstNode(s.charAt(0)));
            }
            insert(s, n.getLessThan(), length);
        }
    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    private boolean find(String s, TstNode node, int length) {
        // If your word is at outside the tree
        if (node == null) {
            return false;
        }
        // For each scenario find at that new node
        if (s.charAt(0) > node.getLetter()) {
            return find(s, node.getGreaterThan(), length);
        } else if (s.charAt(0) < node.getLetter()) {
            return find(s, node.getLessThan(), length);
        } else {
            // If at the end of a word return if it is a word
            if (length == 1) {
                return node.isWord();
            }
            // Same as above, but change the word and length because the current character is being accepted
            return find(s.substring(1), node.getEquals(), length - 1);
        }
    }
}
