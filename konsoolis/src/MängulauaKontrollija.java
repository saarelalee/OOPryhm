public class MängulauaKontrollija {
    public boolean kasSobib(int pikkus, int laius) {
        if ((pikkus * laius) % 2 == 0) return true;
        else return false;
    }

    public boolean kasLahendatud(char[][] maatriks) {
        for (int i = 0; i < maatriks.length; i++) {
            for (int j = 0; j < maatriks[i].length; j++) {
                if (maatriks[i][j] != '_') {
                    return false;
                }
            }
        }
        return true;
    }
}
