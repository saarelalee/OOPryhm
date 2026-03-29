public class MängulauaKontrollija {

    // Hetkel ainult proovimiseks
    public void main() {
        MängulauaKoostaja m = new MängulauaKoostaja(5,5);
        // määrab, kas ka suured ja väikesed tähed on segamini
        // m.raskemTase();
        char[][] maatriks = m.koosta();
        System.out.println(kasSobib(maatriks));
        System.out.println("---");

        for (char[] maatrik : maatriks) {
            System.out.println(maatrik);
        }
    }

    public boolean kasSobib(char[][] mänguLaud) {
        int pikkus = mänguLaud.length;
        int laius = mänguLaud[0].length;

        if ((pikkus * laius) % 2 == 0) return true;
        else return false;
    }
}
