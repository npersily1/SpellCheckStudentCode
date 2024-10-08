public class Tst {
    TstNode root;

    public Tst(TstNode r) {
        root = r;
    }

    public void insert(String s) {
        insert(s, root, s.length());
    }

    public void insert(String s, TstNode n, int length) {

        if (length == 1) {
            n.setWord(true);
            return;
        }

        if (s.charAt(0) > n.getLetter()) {
            if(n.getGreaterThan() == null) {
                n.setGreaterThan(new TstNode(s.charAt(0)));
            }
            insert(s, n.getGreaterThan(), length);
        } else if (s.charAt(0) == n.getLetter()) {
            if(n.getEquals() == null) {
                n.setEquals(new TstNode(s.charAt(1)));
            }
            insert(s.substring(1), n.getEquals(), length - 1);
        } else {
            if(n.getLessThan() == null) {
                n.setLessThan(new TstNode(s.charAt(0)));
            }
            insert(s, n.getLessThan(), length);
        }
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
