
public class Film {
    String nazwa;
    String gatunek;
    int rok;
    int dlugosc;

    public Film() {
// pusty konstruktor
    }

    public Film(String n, String g, int r, int d) {
        this.nazwa = n;
        this.gatunek = g;
        this.rok = r;
        this.dlugosc = d;
    }

    public int dajrok() {
        return this.rok;
    }

    public int dajdl() {
        return this.dlugosc;
    }

    public String dajnazwe() {
        return this.nazwa;
    }


}
