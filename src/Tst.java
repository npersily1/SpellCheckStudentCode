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
            n = new TstNode(s.charAt(0));
            creatChain(s,n).setWord(true);
            return;
        }
        if (length == 0) {
            n.setWord(true);
            return;
        }

        if (s.charAt(0) > n.getC()) {
            insert(s, n.getGreaterThan(), length);
        } else if (s.charAt(0) == n.getC()) {
            insert(s.substring(1), n.getEquals(), length - 1);
        } else {
            insert(s, n.getLessThan(), length);
        }
    }
    private TstNode creatChain(String s, TstNode n) {
        if(s.equals("")) {
            return n;
        }
        n.setEquals(new TstNode(s.charAt(0)));
        return creatChain(s.substring(1),n.getEquals());

    }

    public boolean find(String s) {
        return find(s, root, s.length());
    }

    public boolean find(String s, TstNode n, int length) {

        if (n == null) {
            return false;
        }
        if (length == 0 && n.isWord()) {
            return true;
        }
        if (s.charAt(0) > n.getC()) {
            return find(s, n.getGreaterThan(), length);
        } else if (s.charAt(0) == n.getC()) {
            return find(s.substring(1), n.getEquals(), length - 1);
        } else {
            return find(s, n.getLessThan(), length);
        }
    }

}
