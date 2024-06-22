package src.Objects;

public class TermException extends Exception {
    private static final long serialVersionUID = 1L;

    public TermException (String term, int line, String solution) {
        super("Na linha " + line +
        " era esperado o termo " + term
        + ". Solução: " +
        solution);
    }
}