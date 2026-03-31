import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Mängulaud {
    private char[][] algneMängulaud;
    private int pikkus = algneMängulaud.length;
    private int laius = algneMängulaud[0].length;
    private int[][] jooksevMängulaud = new int[pikkus][laius];

    public Mängulaud(char[][] mängulaud) {
        this.algneMängulaud = mängulaud;
    }

    public void kuvaMängulaud(){
        for (int i = 0; i < pikkus; i++) {
            String rida = "";
            for (int j = 0; j < laius; j++) {
                if(jooksevMängulaud[i][j] == 0) rida+="#";
                else if(jooksevMängulaud[i][j]== 1) rida+=" ";
            }
            System.out.println(rida);
        }
    }

    public int[][] sisestaKoordinaadid(){
        //kasutajalt koordinaartide küsimine ja nende kontrollimine
        Scanner s = new Scanner(System.in);
        KoordinaadiKontrollija kontrollija = new KoordinaadiKontrollija(pikkus,laius);
        int[][] koordinaadid = new int[2][2];
        for (int i = 1; i < 3; i++) {
            boolean sobib = false;
            int r = 0;
            int v = 0;
            while (!sobib) {
                System.out.println("Sisesta elemendi "+ i+ " koordinaadid: (rida veerg)");
                String[] sisestatudKoordinaadid = s.nextLine().split(" ");
                r = Integer.parseInt(sisestatudKoordinaadid[0]);
                v = Integer.parseInt(sisestatudKoordinaadid[1]);
                sobib = kontrollija.kontrolli(r,v);
            }
            koordinaadid[i][0] = r;
            koordinaadid[i][1] = v;

        }
        s.close();
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
