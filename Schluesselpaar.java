import java.math.BigInteger;

/**
 * Die Klasse Schluesselpaar kombiniert die beiden Klassen Publickey und PrivateKey
 * @author danireich
 */
public class Schluesselpaar {
    /**
     * Das Schluesselpaar besteht aus dem Attribut Publickey
     */
    private Publickey publickey;
    /**
     * und dem Attribut PrivateKey
     */
    private PrivateKey privatekey;

    /**
     * der Schluesselpaar Konstruktor wird mit zwei Primzahlen aufgerufen und generiert die Schluessel
     * die Generatorzahl berechnet sich aus p*q
     * Phi(G) berechnet sich aus (p-1)*(q-1)
     * e wird berechnet indem e zu Anfang auf 2 gesetzt wird, da sowohl 1 und 2 keine Primzahlen sind
     * zu e=2 wird mit der while-Schleife solange 1 dazu addiert wie der groesste gemeinsame Teiler von e und Phi(G) nicht 1 ist
     * d wird mit dem mod Inversen von e und Phi(G) berechnet
     * der Publickey wird mit e und g erstellt
     * der PrivateKey wird mit d und g erstellt
     * @param p Primzahl
     * @param q Primzahl
     */
    public Schluesselpaar(long p, long q) {
        long g = p*q;

        BigInteger phivonG = BigInteger.valueOf((p-1)*(q-1));
        BigInteger e = BigInteger.valueOf(2);

        while (!e.gcd(phivonG).equals(BigInteger.valueOf(1))) {
            e = e.add(BigInteger.valueOf(1));
        }
        BigInteger d = e.modInverse(phivonG);
        this.publickey = new Publickey(e.longValue(), g );
        this.privatekey = new PrivateKey(d.longValue(), g);
    }

    /**
     * Getter fuer den Publickey
     * @return der Publickey wird zurueckgegeben
     */
    public Publickey getPublickey() {
        return publickey;
    }

    /**
     * Getter fuer den PrivateKey
     * @return der Privatekey wird zurueckgegeben
     */
    public PrivateKey getPrivatekey() {
        return privatekey;
    }
}

