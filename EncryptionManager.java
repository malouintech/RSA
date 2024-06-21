import java.io.FileNotFoundException;
import java.math.BigInteger;

/**
 * Encryptionmanager beinhaltet die beiden Funktionen entschluesseln() und verschluesseln()
 * @author malou
 */

public class EncryptionManager {

    /**
     * in dem Attribut keys werden die generierten Schluessel gespeichert
     */
    private Schluesselpaar keys;

    /**
     * Encryption Manager Konstruktor
     * @param keys das Schluesselpaar mit dem entschluesselt bzw. verschluesselt werden soll
     */
    public EncryptionManager(Schluesselpaar keys){ }

    /**
     * entschluesseln() entschluesselt mit dem privatekey die .txt-Datei des uebergebenen Pfades
     * @param pfad Der Pfad der Datei die entschluesselt werden soll
     * @param privateKey Der Schluessel mit dem die verschluesselten Zeichen entschluesselt werden können
     * @return der entschluesselte Text wird zurückgegeben
     * @throws FileNotFoundException
     */
    public String entschluesseln(String pfad, PrivateKey privateKey) throws FileNotFoundException {
        Files email = new Files();
        String inhalt;
        inhalt = email.readFile(pfad);
        inhalt = inhalt.replaceAll("\n", " ");
        String[] splitInhalt = inhalt.split(" ");

        int[] intInhalt = new int[splitInhalt.length];
        for (int i = 1; i < splitInhalt.length; i++) {
            intInhalt[i] = Integer.parseInt(splitInhalt[i]);
        }
        BigInteger[] emaildecrypted = new BigInteger[intInhalt.length];
        for (int i = 0; i < intInhalt.length; i++) {
            emaildecrypted[i] = BigInteger.valueOf(intInhalt[i]);
            emaildecrypted[i] = emaildecrypted[i].modPow(BigInteger.valueOf(privateKey.getD()), BigInteger.valueOf(privateKey.getG()));
        }
        int[] decrypting = new int[emaildecrypted.length];
        for (int i = 0; i < decrypting.length; i++) {
            decrypting[i] = emaildecrypted[i].intValue();
        }
        char[] teilentschluesselt = new char[decrypting.length];
        for (int i = 0; i < decrypting.length; i++) {
            teilentschluesselt[i] = (char) decrypting[i];
        }
        String entschluesselt = new String(teilentschluesselt);
        return entschluesselt;
    }

    /**
     * verschluesseln() verschluesselt mit dem uebergebenen publickey die .txt-Datei des uebergebenen Pfades
     * @param pfad Der Pfad der Datei die verschluesselt werden soll
     * @param publickey Der Schluessel mit dem die Zeichen verschluesselt werden können
     * @return die verschluesselte Datei wird als String zurueckgegeben
     * @throws FileNotFoundException
     */
    public String verschluesseln(String pfad, Publickey publickey) throws FileNotFoundException {
        Files email = new Files();
        String inhalt;
        inhalt = email.readFile(pfad);
        char[] charInhalt = inhalt.toCharArray();
        BigInteger[] emailencrypted = new BigInteger[charInhalt.length];
        String[] verschluesselt = new String[charInhalt.length];
        for (int i = 0; i < charInhalt.length; i++) {
            emailencrypted[i] = BigInteger.valueOf(charInhalt[i]);
            emailencrypted[i] = emailencrypted[i].modPow(BigInteger.valueOf(publickey.getE()), BigInteger.valueOf(publickey.getG()));
            verschluesselt[i] = String.valueOf(emailencrypted[i]);
        }
        String verschluesselt_final = String.join(" ", verschluesselt);
        return verschluesselt_final;
    }


}
