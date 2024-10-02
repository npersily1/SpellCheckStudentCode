public class Node {

    private Node[] children;
    private boolean isWord;

    public Node() {
        children = new Node[256];
        isWord = false;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}