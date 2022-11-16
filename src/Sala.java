public class Sala {
    int numer;
    int ilosc_miejsc;
    int ilosc_zajetych;

    Sala() {
// pusty konstruktor
    }

    Sala(int n, int il)
    {
        this.numer=n;
        this.ilosc_miejsc=il;
        this.ilosc_zajetych=0;
    }
}
