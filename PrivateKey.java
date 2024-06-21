/**
 * der PrivateKey ist grundlegender Bestandteil des Schluesselpaares mit dem die Verschluesselung bzw. Entschluesselung durchgefuehrt wird
 * @author danireich
 */

public class PrivateKey {
    /**
     * long d ist einer der Werte des PrivateKeys
     */
    private long d;
    /**
     * long g ist die Generatorzahl des PrivateKeys
     */
    private long g;

    /**
     * PrivateKey Konstruktor
     * @param d der Wert auf den d gesetzt wird
     * @param g der Wert auf den g gesetzt wird
     */
    public PrivateKey(long d, long g) {
        this.d = d;
        this.g = g;
    }

    /**
     * Getter fuer D
     * @return gibt die Variable d zurueck
     */
    public long getD() {return d;}

    /**
     * Getter fuer G
     * @return gibt die Variable g zurueck
     */
    public long getG() {return g;}
}
