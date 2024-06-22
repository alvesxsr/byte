package src.Objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.ByteLanguage;

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

    // Pegar todos os termos, removendo os espaços
    public static List<TermModel> findTerms() 
    throws FileNotFoundException, IOException {

        List<TermModel> allTerms = new ArrayList<>();

        try (
            BufferedReader reader = new BufferedReader(
                new FileReader(
                    ByteLanguage.getPathFile() + ByteLanguage.getNameFile() 
                )
            );
        ) {
            // Acessa cada linha do código
            for (int line = 1; reader.ready(); line++) {

                // Dividi cada linha por termos separados por espaço
                String [] termsLine = reader.readLine().split(" ");

                // Acessa cada termo em uma linha e adiciona os em allTerms
                for (String term : termsLine) {
                    // Verifica se não é só um espaço em branco
                    if (!term.isEmpty()) {
                        allTerms.add(new TermModel(term, line));
                    }
                }
            }           
        }

        return allTerms;
    }
}