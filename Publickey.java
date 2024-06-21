/**
 * der Publickey ist grundlegender Bestandteil des Schluesselpaares mit dem die Verschluesselung bzw. Entschluesselung durchgefuehrt wird
 * @author danireich
 */

public class Publickey {

    /**
     * long e ist einer der Werte des Publickeys
     */
    private long e;
    /**
     * long g ist die Generatorzahl des Publickeys
     */
    private long g;

    /**
     * Publickey Konstruktor
     * @param e der Wert auf den e gesetzt wird
     * @param g der Wert auf den g gesetzt wird
     */

    public Publickey(long e, long g){
        this.e = e;
        this.g = g;
    }

    /**
     * Getter fuer E
     * @return gibt den Wert der Variable E zurueck
     */
    public long getE() {
        return e;
    }

    /**
     * Getter fuer G
     * @return gibt den Wert der Variable G zurueck
     */
    public long getG() {
        return g;
    }
}
