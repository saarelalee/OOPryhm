import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/***
 * Genereerib mängu alguses välja maatriksi
 * ning lisab sinna suvalised tähed
 * @author Maarek Vettik
 */

public class MängulauaKoostaja {
    private int pikkus;
    private int laius;
    private boolean kasRaskem = false;

    public MängulauaKoostaja(int pikkus, int laius) {
        this.pikkus = pikkus;
        this.laius = laius;

    }

    // Koostab sümbolmaatriksi etteantud isendiväljadega ning tagastab selle
    public char[][] koosta() {
        char[][] mängulaud = new char[pikkus][laius];
        List<Character> sümbolid = new ArrayList<>();
        char[] tähestik = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int täheIndeks = 0;

        while (sümbolid.size() < pikkus*laius) {
            char sümbol = tähestik[täheIndeks++];

            if (kasRaskem) {
                int juhuarv = 1 + (int) (Math.random() * 2);
                if (juhuarv == 1) sümbol = Character.toUpperCase(sümbol);
            }
            sümbolid.add(sümbol);
            sümbolid.add(sümbol);
        }
        Collections.shuffle(sümbolid);

        int indeks = 0;
        for (int rida = 0; rida < pikkus; rida++) {
            for (int veerg = 0; veerg < laius; veerg++) {
                mängulaud[rida][veerg] = sümbolid.get(indeks++);
            }
        }
        return mängulaud;
    }

    public void raskemTase() {
        kasRaskem = true;
    }
}
