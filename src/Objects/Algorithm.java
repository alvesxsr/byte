package src.Objects;

import java.util.List;

import src.ByteLanguage;

public class Algorithm {

    // Armazenar o nome do algoritmo (classe)
    private static String algorithmName;

    public static String getAlgorithmName () {
        return algorithmName;
    }

    // ---
    
    public static void findAlgorithm () throws TermException {
        
        List<TermModel> allTerms = ByteLanguage.getAllTerms();

    }
}