package src.Objects;

public class KeyWords {

    public static boolean keyAlgoritmo (String nameTerm) {
        return nameTerm.matches("^(?i)algoritmo");
    }

    public static boolean keyVar (String nameTerm) {
        return nameTerm.matches("^(?i)var");
    }

    // ---

    public static boolean keyEscrever (String nameTerm) {
        return nameTerm.matches("^(?i)escreva");
    }

    public static boolean keyLer (String nameTerm) {
        return nameTerm.matches("^(?i)leia");
    }

    public static boolean keyCondicional (String nameTerm) {
        return nameTerm.matches("^(?i)se");
    }

    public static boolean keyAtribuir (String nameTerm) {
        return nameTerm.matches("<-");
    }

    // ---

    public static boolean keyIniciar (String nameTerm) {
        return nameTerm.matches("(?i)inicio||(?i)início");
    }

    public static boolean keyFinalizar (String nameTerm) {
        return nameTerm.matches("^(?i)fim");
    }

    // ---
    
    public static boolean anyComes (String term) {

        if (keyAlgoritmo(term)) {
            return true;
        }

        if (keyAtribuir(term)) {
            return true;
        }

        if (keyCondicional(term)) {
            return true;
        }

        if (keyEscrever(term)) {
            return true;
        }

        if (keyFinalizar(term)) {
            return true;
        }

        if (keyIniciar(term)) {
            return true;
        }

        if (keyLer(term)) {
            return true;
        }

        if (keyVar(term)) {
            return true;
        }

        return false;
    }

}