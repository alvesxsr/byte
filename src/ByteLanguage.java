package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import src.Objects.TermModel;

public class ByteLanguage {

    // Obtidos pelos args[]
    private static String pathFile;
    private static String nameFile;

    public static String getPathFile() {
        return pathFile;
    }

    public static void setPathFile(String pathFile) {
        ByteLanguage.pathFile = pathFile;
    }

    public static String getNameFile() {
        return nameFile;
    }

    public static void setNameFile(String nameFile) {
        ByteLanguage.nameFile = nameFile;
    }

    // Armazenar termos e acessar eles
    private static List<TermModel> allTerms;

    public static List<TermModel> getAllTerms() {
        return allTerms;
    }

    // --------------
    public static void main(String[] args) {

        // args[0]
        setPathFile("src/");
        // args[1]
        setNameFile("Main.byte");

        try {
            ByteLanguage.allTerms = TermModel.findTerms();  
        }
        
        catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Arquivo " + getNameFile() + " não encontrado");
        }

        catch (IOException ioException) {
            System.out.println("Não foi possível definir esse erro. Mensagem: " + ioException.getMessage());
        }
    }
}