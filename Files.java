import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;

/**
 * Die Klasse Files stellt Funktionen zum einlesen und schreiben von .txt-Dateien zur Verfügung
 * @author danireich
 */

public class Files {
    /**
     * Das Attribut inhalt wird als leerer String initialisiert
     * es dient zur Speicherung des mit readFile() eingelesenen Inhaltes
     */
    private String inhalt = "";

    /**
     * readFile() liest den inhalt einer .txt-Datei ein und gibt diesen zurueck
     * @param pfad Speicherort der zu lesenden .txt-Datei
     * @return inhalt des eingelesenen Textes als String
     * @throws FileNotFoundException
     */
    public String readFile(String pfad) throws FileNotFoundException {

        File email = new File(pfad);
        Scanner emailReader = new Scanner(email);
        while (emailReader.hasNextLine()) {
            String data = emailReader.nextLine();
            inhalt = inhalt + "\n" + data;
        }
        emailReader.close();
        return inhalt;
    }

    /**
     * writeFile() schreibt den uebergebenen text in eine bereits vorhandene .txt-Datei
     * ist die übergebene Datei nicht leer, wird der inhalt ueberschrieben
     * @param outputPfad Pfad der Datei in die hineingeschrieben wird
     * @param text der Inhalt der in die Datei geschrieben wird
     */
    public void writeFile(String outputPfad, String text) {
        try (FileWriter fw = new FileWriter(outputPfad, false)) {
            fw.write("" + text);
            fw.flush();
        } catch (IOException e) {
            System.out.println("Das Schreiben der Datei war leider nicht möglich! ");
        } catch (Exception e) {
            System.out.println("Unbekannter Fehler aufgetreten");
        }
    }

}

