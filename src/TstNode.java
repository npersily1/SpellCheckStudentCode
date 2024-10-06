public class TstNode {
    private char c;
    private TstNode lessThan;
    private TstNode equals;
    private TstNode greaterThan;
    private boolean isWord;

    public TstNode() {

    }
    public TstNode(char c) {
        this.c = c;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TstNode getLessThan() {
        return lessThan;
    }

    public void setLessThan(TstNode lessThan) {
        this.lessThan = lessThan;
    }

    public TstNode getEquals() {
        return equals;
    }

    public void setEquals(TstNode equals) {
        this.equals = equals;
    }

    public TstNode getGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(TstNode greaterThan) {
        this.greaterThan = greaterThan;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}

