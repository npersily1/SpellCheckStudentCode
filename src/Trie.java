public class Trie {
    private Node root;

    public Trie(Node r) {
        root = r;
    }
    public void insert(String s) {
        insert(s,root);
    }
    private void insert(String s, Node root) {
        if(s.length() == 1) {
            root.getChildren()[s.charAt(0)] = new Node();
            root.getChildren()[s.charAt(0)].setWord(true);
            return;
        }
        if(root.getChildren()[s.charAt(0)] == null) {
            root.getChildren()[s.charAt(0)] = new Node();
        }
        insert(s.substring(1), root.getChildren()[s.charAt(0)]);
    }
    public boolean find(String s) {
        return find(s,root);
    }
    private boolean find(String s, Node root) {
         if(root.getChildren()[s.charAt(0)] == null) {
             return false;
         }
         if(s.length() == 1 && root.getChildren()[s.charAt(0)].isWord()) {
              return true;
         }
         return find(s.substring(1), root.getChildren()[s.charAt(0)]);
    }
}
