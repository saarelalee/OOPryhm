import java.util.concurrent.TimeUnit;

public class Tulemused {
    private int õigeidPaare;

    public Tulemused() {
        this.õigeidPaare = 0;
    }

    public void leitudPaar() {
        õigeidPaare++;
    }

    public int getÕigeidPaare() {
        return õigeidPaare;
    }

    public void väljastaTulemus(long aeg, char[][] algne, boolean mängKäib) {
        // Muudab millisekundid sekunditeks
        long kestusSekundites = TimeUnit.SECONDS.convert(aeg, TimeUnit.NANOSECONDS);

        System.out.println("------------");
        System.out.println("Leitud õigeid paare: " + õigeidPaare);
        System.out.println("Mängu kestus: " + kestusSekundites + " sekundit");

        // Kui mäng ei lõppenud kõigi paaride leidmisega
        if (mängKäib) {
            System.out.println("Täielik mängulaud:");
            for (char[] element : algne) {
                System.out.println(element);
            }
        }


    }

}
