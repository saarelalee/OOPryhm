import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Mängulaud {
    private char[][] algneMängulaud;
    private int pikkus;
    private int laius;
    private int[][] jooksevMängulaud;

    public Mängulaud(char[][] mängulaud) {
        this.algneMängulaud = mängulaud;
        this.pikkus =algneMängulaud.length;
        this.laius = algneMängulaud[0].length;
        this.jooksevMängulaud = new int[pikkus][laius];
    }

    public void kuvaMängulaud(){
        System.out.println("MÄNGULAUD");
        for (int i = 0; i < pikkus; i++) {
            String rida = "";
            for (int j = 0; j < laius; j++) {
                if(jooksevMängulaud[i][j] == 0) rida+="#";
                else if(jooksevMängulaud[i][j]== 1) rida+="_";
            }
            System.out.println(rida);
        }
    }

    public int[][] sisestaKoordinaadid(Scanner s){
        //kasutajalt koordinaartide küsimine ja nende kontrollimine
        KoordinaadiKontrollija kontrollija = new KoordinaadiKontrollija(pikkus,laius);
        int[][] koordinaadid = new int[2][2];
        for (int i = 1; i < 3; i++) {
            boolean sobib = false;
            int r = 0;
            int v = 0;
            while (!sobib) {
                System.out.println("Sisesta elemendi "+ i+ " koordinaadid: (rida veerg)");

                String sisend = s.nextLine();

                // n.ö "sentinel" väärtus, mis tähistab mängu lõpusoovi
                if (sisend.equals("lõpp")) return new int[][]{{-1}};

                String[] sisestatudKoordinaadid = sisend.split(" ");
                r = Integer.parseInt(sisestatudKoordinaadid[0]);
                v = Integer.parseInt(sisestatudKoordinaadid[1]);
                sobib = kontrollija.kontrolli(r,v);
            }
            koordinaadid[i-1][0] = r;
            koordinaadid[i-1][1] = v;

        }
        return koordinaadid;
    }

    public void kuvaElemendid(int[][] koordinaadid){
        int r1 = koordinaadid[0][0];
        int v1 = koordinaadid[0][1];
        int r2 = koordinaadid[1][0];
        int v2 = koordinaadid[1][1];

        for (int i = 0; i < pikkus; i++) {
            String rida = "";
            for (int j= 0; j < laius; j++) {
                if((i==r1 && j==v1)||(i==r2 && j ==v2)){
                    rida+=algneMängulaud[i][j];
                } else if(jooksevMängulaud[i][j] == 0) rida+="#";
                else if(jooksevMängulaud[i][j]== 1) rida+=" ";
            }
            System.out.println(rida);
        }
    }

    public boolean kasElemendidSamad(int[][] koordinaadid){
        int r1 = koordinaadid[0][0];
        int v1 = koordinaadid[0][1];
        int r2 = koordinaadid[1][0];
        int v2 = koordinaadid[1][1];

        if(algneMängulaud[r1][v1] == algneMängulaud[r2][v2]) {
            muudaKuvatavLaud(r1,v1);
            muudaKuvatavLaud(r2,v2);
            return true;
        }
        else return false;
    }

    public void muudaKuvatavLaud(int reakoordinaat, int veerukoordinaat){
        jooksevMängulaud[reakoordinaat][veerukoordinaat] = 1;
    }
}
