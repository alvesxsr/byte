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
        untilKeyAlgorithm();
        findAlgorithmName();
    }

    private static void untilKeyAlgorithm () throws TermException {

        // Passar até encontrar a palavra algoritmo
        while (!ByteLanguage.getAllTerms().isEmpty()) {

            List<TermModel> allTerms = ByteLanguage.getAllTerms();

            TermModel termModel = allTerms.get(0);

            // Se encontrar uma palavra chave antes de algoritmo
            if (KeyWords.anyComes(termModel.term) && !KeyWords.keyAlgoritmo(termModel.term)) {
                throw new TermException("Na linha " + termModel.line + " existe uma palavra chave" +
                ", porém ainda não foi definido o algoritmo atual. Solução: defina ele usando a palavra algoritmo na primeira linha.");
            }

            else if (KeyWords.keyAlgoritmo(termModel.term)) {
                ByteLanguage.removeFirstAllTerms();
                return;
            }

            ByteLanguage.removeFirstAllTerms();
        }

        throw new TermException("Não foi possível encontrar o algoritmo. Solução: defina ele usando a palavra algoritmo.");
    }

    private static void findAlgorithmName () throws TermException {

        String name = "";

        // Enquanto não acabar os termos
        while (!ByteLanguage.getAllTerms().isEmpty()) {
            
            List<TermModel> allTerms = ByteLanguage.getAllTerms();

            TermModel termModel = allTerms.get(0);

            if (KeyWords.anyComes(termModel.term)) {
                throw new TermException("Na linha " + termModel.line +
                ", o algoritmo não foi estabelecido corretamente. Solução: " + 
                "formate para ficar no modelo 'Algoritmo nome;'");  
            }
            
            // Laço para pegar cada letra do nome
            for (char letterName : termModel.letters) {

                if (letterName == ';') {

                    // Verificar se ele não foi pulado e existe uma palavra chave no lugar dele
                    if (KeyWords.anyComes(name)) {
                        throw new TermException("Na linha " + termModel.line +
                        " deveria ter o nome do algoritmo. Solução: " + 
                        "não use palavras chaves no nome dele");
                    }

                    algorithmName = name;
                    
                    String term = termModel.term;
                    
                    // Verificar se havia algo após o ponto vírgula
                    if (!term.matches(";$")) {

                        // Conseguir posição depois do ponto vírgula
                        int commaPosition = term.indexOf(";") + 1;
                        
                        // Mudar o primeiro elemento para o elemento depois do ponto vírgula
                        ByteLanguage.setFirstElementAllTerms(new TermModel(
                            term.substring(commaPosition, term.length()), 
                            termModel.line
                            ) 
                        );
                    }

                    return;
                }

                else {
                    name += letterName;
                }
            }

            ByteLanguage.removeFirstAllTerms();
        }

    }
}