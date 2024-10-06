public class Tst {
    TstNode root;
    public Tst(TstNode r) {
        root=r;
    }
    public void insert(String s) {
        insert(s,root,s.length());
    }
    public void insert(String s, TstNode n, int length) {

        if(n == null) {
            n = new TstNode(s.charAt(0));
            for (int i = 1; i < length - 1; i++) {
                n.setEquals(new TstNode(s.charAt(i)));
                n = n.getEquals();
            }
            n.setWord(true);
            return;
        }
        if(length == 0) {
            n.setWord(true);
            return;
        }

        if(s.charAt(0) > n.getC()) {
            insert(s.substring(1),n.getGreaterThan(), length - 1);
        } else if (s.charAt(0) == n.getC()) {
            insert(s.substring(1),n.getEquals(), length - 1);
        }
        else {
            insert(s.substring(1),n.getLessThan(), length - 1);
        }
    }
    public boolean find(String s) {
        return find(s,root, s.length());
    }
    public boolean find(String s, TstNode n, int length) {

        if(n == null) {
            return false;
        }
        if(length == 0 && n.isWord()) {
            return true;
        }
        if(s.charAt(0) > n.getC()) {
           return find(s.substring(1),n.getGreaterThan(), length - 1);
        } else if (s.charAt(0) == n.getC()) {
            return find(s.substring(1),n.getEquals(), length - 1);
        }
        else {
            return find (s.substring(1),n.getLessThan(), length - 1);
        }
    }

}
