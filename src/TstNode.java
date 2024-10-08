// This class represents a node in a Ternary Search Tree which contains wors




public class TstNode {
    private char letter;
    private TstNode lessThan;
    private TstNode equals;
    private TstNode greaterThan;
    private boolean isWord;

    public TstNode(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
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

