public class KoordinaadiKontrollija{
    private int maatriksiPikkus;
    private int maatriksiLaius;

    public KoordinaadiKontrollija(int maatriksiPikkus, int maatriksiLaius) {
        this.maatriksiPikkus = maatriksiPikkus;
        this.maatriksiLaius = maatriksiLaius;
    }


    public boolean kontrolli(int reaKoordinaat, int veeruKoordinaat){
        if(reaKoordinaat>maatriksiPikkus || veeruKoordinaat>maatriksiLaius) {
            System.out.println("Sisestatud koordinaadid on maatriksi piiridest väjas!");
            return false;
        }
        else return true;

    }
}
