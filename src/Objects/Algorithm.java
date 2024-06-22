package src.Objects;

import java.util.ArrayList;
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
        untilKeyAlgorithm();
        ByteLanguage.getAllTerms().forEach(
            x -> System.out.println(x.term)
        );
    }

    private static void untilKeyAlgorithm () throws TermException {

        // Passar até encontrar a palavra algoritmo
        while (!ByteLanguage.getAllTerms().isEmpty()) {

            List<TermModel> allTerms = ByteLanguage.getAllTerms();

            TermModel termModel = allTerms.get(0);

            // Se encontrar uma palavra chave antes de algoritmo
            if (KeyWords.anyComes(termModel.term) && !KeyWords.keyAlgoritmo(termModel.term)) {
                throw new TermException("Na linha " + termModel.line + " existe uma palavra chave" +
                ", porém ainda não foi definido o algoritmo atual. Defina ele usando a palavra algoritmo na primeira linha.");
            }

            else if (KeyWords.keyAlgoritmo(termModel.term)) {
                ByteLanguage.removeFirstInAllTerms();
                return;
            }

            ByteLanguage.removeFirstInAllTerms();
        }

        throw new TermException("Não foi possível encontrar o algoritmo. Defina ele usando a palavra algoritmo.");
    }

}