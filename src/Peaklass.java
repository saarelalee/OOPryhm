import javax.swing.*;
import java.util.Scanner;

public class Peaklass {
    static void main(String[] args) {
        //kasutajale mängu juhiste kuvamine
        System.out.println("Memoriin.\n" +
                "Leia mängulaualt võimalikult kiiresti sümbolite paarid.\n" +
                "Mäng lõppeb, kui kõik paarid on leitud " +
                "või \"lp\" sisestamisel.\n" +
                "Pane tähele! Mängulaual laiusega m " +
                "ja pikkusega n arvestatakse " +
                "elementide koordinaate järgnevalt:\n" +
                "(0,0) (0,1) … (0,m)\n" +
                "(1,0) (1,1) … (1,m)\n" +
                "  …     …   …   …\n" +
                "(n,0) (n,1) … (n,m)");

        //kasutalaja määrab mängulaua suuruse
        int pikkus = 1;
        int laius = 1;
        MängulauaKontrollija kontrollija = new MängulauaKontrollija();

        Scanner s = new Scanner(System.in);
        while (!kontrollija.kasSobib(pikkus, laius)){
            System.out.println("Mängulaua mõõtmed peab sisestama nii, et mängulaual oleks paaris arv elemente");
            System.out.println("Sisesta mängulaua pikkus.");
            pikkus = s.nextInt();
            System.out.println("Sisesta mängulaua laius.");
            laius = s.nextInt();

        }

        //luuakse vastava suurusega mängulaud
        MängulauaKoostaja mängulauaKoostaja = new MängulauaKoostaja(pikkus,laius);
        //kasutaja otsustab mängu raskusastme
        boolean kasutajaPoleVastanud = true;
        while(kasutajaPoleVastanud){
            s.nextLine();
            System.out.println("Kas soovid mängida raskemal tasemel? (jah/ei) ");
            String sisend = s.nextLine();
            if(sisend.equals("jah")) {
                mängulauaKoostaja.raskemTase();
                kasutajaPoleVastanud = false;
            } else if (!sisend.equals("ei")) {
                System.out.println("Palun sisestage korrektne vastus.");
            } else kasutajaPoleVastanud = false;
        }


        //Mängu põhiosa
        // mängitakse seni kuni kasutaja sisestab lõpumärguande või kui leitakse kõik sümbolite paarid
        boolean mängKäib = true;
        char[][] laud = mängulauaKoostaja.koosta();
        Mängulaud mängulaud = new Mängulaud(laud);
        while (mängKäib){
            mängulaud.kuvaMängulaud();
            int[][] elementideKoordinaadid = mängulaud.sisestaKoordinaadid(s);
            mängulaud.kuvaElemendid(elementideKoordinaadid);
            if(mängulaud.kasElemendidSamad(elementideKoordinaadid)){
                System.out.println("Leidsid paari!");
            }else{
                System.out.println("Proovi uuesti!");
            }


        }
        s.close();



    }
}
