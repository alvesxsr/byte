package src;
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

    // --------------
    public static void main(String[] args) {

        // args[0]
        setPathFile("../");
        // args[1]
        setNameFile("Main.byte");

    }
}