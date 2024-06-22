package src.Objects;

public class TermModel {
    
    public final String term;
    public final int line;
    public final char [] letters;

    public TermModel (String term, int line) {
        this.term = term;
        this.line = line;
        this.letters = new char[term.length()];

        for (int i = 0; i < term.length(); i++) {
            this.letters[i] = term.charAt(i);
        }
    }
}