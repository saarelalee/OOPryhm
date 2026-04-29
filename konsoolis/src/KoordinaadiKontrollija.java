public class KoordinaadiKontrollija{
    private int maatriksiPikkus;
    private int maatriksiLaius;
    private boolean[][] kasLeitud;

    public KoordinaadiKontrollija(int maatriksiPikkus, int maatriksiLaius) {
        this.maatriksiPikkus = maatriksiPikkus;
        this.maatriksiLaius = maatriksiLaius;
        this.kasLeitud = new boolean[maatriksiPikkus][maatriksiLaius];
    }

    public boolean[][] getKasLeitud() {
        return kasLeitud;
    }

    public void märgiLeitud(int[][] koordinaadid) {
        kasLeitud[koordinaadid[0][0]][koordinaadid[0][1]] = true;
        kasLeitud[koordinaadid[1][0]][koordinaadid[1][1]] = true;
    }

    public boolean kontrolli(int reaKoordinaat, int veeruKoordinaat){
        if(reaKoordinaat>=maatriksiPikkus || veeruKoordinaat>=maatriksiLaius) {
            System.out.println("Sisestatud koordinaadid on maatriksi piiridest väjas!");
            return false;
        } else {
            if (kasLeitud[reaKoordinaat][veeruKoordinaat]) {
                System.out.println("Sisestatud element on juba leitud!");
                return false;
            } else {
                return true;
            }
        }
    }
}
