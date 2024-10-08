public class Tst {
    TstNode root;

    public Tst(TstNode r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    public void insert(String s, TstNode n, int length) {


        if (s.charAt(0) > n.getLetter()) {
            if (n.getGreaterThan() == null) {
                n.setGreaterThan(new TstNode(s.charAt(0)));
            }
            insert(s, n.getGreaterThan(), length);
        } else if (s.charAt(0) == n.getLetter()) {
            if (length == 1) {
                n.setWord(true);
                return;
            }

            if (n.getEquals() == null) {
                n.setEquals(new TstNode(s.charAt(1)));
            }
            insert(s.substring(1), n.getEquals(), length - 1);
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

    public boolean find(String s, TstNode node, int length) {
        // If your word is at outside the tree
        if (node == null) {
            return false;
        }

        if (s.charAt(0) > node.getLetter()) {
            return find(s, node.getGreaterThan(), length);
        } else if (s.charAt(0) < node.getLetter()) {
            return find(s, node.getLessThan(), length);
        } else {
            if (length == 1) {
                return node.isWord();
            }
            return find(s.substring(1), node.getEquals(), length - 1);
        }
    }

}
