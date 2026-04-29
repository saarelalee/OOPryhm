package com.oop2.memoriinjavafx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Tulemused {
    private int õigeidPaare;
    private long kulunudAeg;

    public Tulemused() {
        this.õigeidPaare = 0;
    }

    public void leitudPaar() {
        this.õigeidPaare++;
    }

    public int getÕigeidPaare() {
        return this.õigeidPaare;
    }

    public long getKulunudAeg() {
        return this.kulunudAeg;
    }

    public void väljastaTulemus(long aeg, char[][] algne, boolean mängKäib) throws IOException {
        // Muudab millisekundid sekunditeks
        long kestusSekundites = TimeUnit.SECONDS.convert(aeg, TimeUnit.NANOSECONDS);
        this.kulunudAeg = kestusSekundites;

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
        kirjutaTulemus();

        Platform.startup(() -> {
            // Vajalik lõimel jooksutamiseks
            Edetabel ed = new Edetabel();
            try {
                ed.start();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void kirjutaTulemus() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("edetabel.txt"))) {
            bw.write("nimi;"+this.õigeidPaare+";"+this.kulunudAeg);
            bw.newLine();
        }
    }
}
