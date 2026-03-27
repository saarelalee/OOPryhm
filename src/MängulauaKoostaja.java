import java.util.Random;

/***
 * Genereerib mängu alguses välja maatriksi
 * ning lisab sinna suvalised tähed
 * @author Maarek Vettik
 */


public class MängulauaKoostaja {
    private int pikkus;
    private int laius;

    public MängulauaKoostaja(int pikkus, int laius) {
        this.pikkus = pikkus;
        this.laius = laius;
    }

    // Koostab sümbolmaatriksi etteantud isendiväljadega ning tagastab selle
    public char[][] koosta() {
        char[][] mängulaud = new char[pikkus][laius];

        // Genereerib suvalise väikese tähe tähestikust, võetud StackOverflow'ist
        // Vastendab arvu ASCII tabeli koodiga
        Random r = new Random();
        char sümbol = (char)(r.nextInt(26) + 'a');

        // 50% võimalus, et sümbol muudetakse hoopis suureks täheks
        int juhuarv = 1 + (int)(Math.random() * 2);
        if (juhuarv == 1) sümbol = Character.toUpperCase(sümbol);

        for (int rida = 0; rida < pikkus; rida++) {
            for (int veerg = 0; veerg < laius; veerg++) {
                mängulaud[rida][veerg] = sümbol;
            }
        }
        return mängulaud;
    }
}
