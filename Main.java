import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) {

        try {

            Schluesselpaar keys = new Schluesselpaar(19, 103); //31 73/ 7 19/ 23 29/ 103 37 /11 und 13 ... g = p*q = mind. 127
            System.out.println("The keys have been generated \n");

            System.out.println("Your Publickey : E = " + keys.getPublickey().getE() + " G = " + keys.getPublickey().getG());
            System.out.println("     Privatekey: D = " + keys.getPrivatekey().getD() + " G = " + keys.getPrivatekey().getG());

            /** Fall 1: Eine geschriebene email soll vor dem versenden verschluesselt werden
             * Datei wird eingelesen
             * abhaengig von den Werten des Publickeys verschluesselt
             * der verschluesselte Text wird in eine neue Datei geschrieben
             */

           EncryptionManager test = new EncryptionManager(keys);
           Files filemanager = new Files();

           String zeilenumbruch = test.verschluesseln("C:/Desktop/zeilenumbruch.txt", keys.getPublickey());
           String textinNumbers = test.verschluesseln("C:/Desktop/zuVerschluesseln.txt", keys.getPublickey());

           System.out.println("\n_______The_encrypted_Text_______");
           System.out.println(textinNumbers.replaceAll(zeilenumbruch, "\n") + "\n________________________________");
           filemanager.writeFile("C:/Desktop/zuEntschluesseln.txt", test.verschluesseln("C:/Desktop/zuVerschluesseln.txt", keys.getPublickey()));

            /** Fall 2: Eine verschluesselte email soll entschluesselt werden
             * Datei wird eingelesen
             * mithilfe des Privatekeys entschlüsselt
             * der entschluesselte Text wird in eine Datei geschrieben
             */
            System.out.println("\n_______The_decrypted_Text_______");
            System.out.println(test.entschluesseln("C:/Desktop/zuEntschluesseln.txt", keys.getPrivatekey()));

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

}