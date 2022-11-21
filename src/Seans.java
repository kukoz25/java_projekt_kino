import javax.swing.*;
import java.text.*;
import java.util.Date;

public class Seans {
    String kod;
    Film f;
    Sala s;
    int cena;
    Date data;
    Date godzina;

    String m;
    Seans() {
        // pusty konstruktor
    }
    Seans(String k, String nazwa_f,int nr_sali,int c,String d, String g, String miejsca)
    {
        this.kod=k;
        String[] p= Wczytywanie.wczytaj("filmy.csv");
        String[] data;
        for(int i=0;i<p.length;i++)
        {
            data=p[i].split(";");
            if(nazwa_f.equals(data[0]))
            {
                f=new Film(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
            }
        }
        p= Wczytywanie.wczytaj("sale.csv");
        for(int i=0;i<p.length;i++)
        {
            data=p[i].split(";");
            if(nr_sali==Integer.parseInt(data[0]))
            {
                s=new Sala(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
            }
        }
        this.cena=c;
        SimpleDateFormat formatterdata = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.data = formatterdata.parse(d);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat formattergodzina= new SimpleDateFormat("HH:mm");
        try {
            this.godzina=formattergodzina.parse(g);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        this.m=miejsca;
        int[][] tab= new int[5][5];
        int tmp=0;
        char tmp2;
        int zajete=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                tmp2=m.charAt(tmp);
                tab[i][j]=Character.getNumericValue(tmp2);
                zajete=zajete+tab[i][j];
                //System.out.println(Integer.toString(zajete));
                tmp++;

            }
        }
        s.ilosc_zajetych=zajete;
    }
    public String dajkod() {return this.kod;}
    public String dajnazwe(){return this.f.dajnazwe();}

    public String dajgat(){return this.f.dajgatunek();}

    public int dajrok(){return this.f.dajrok();}

    public int dajdl(){return this.f.dajdl();}

    public int dajnrsali(){return this.s.numer;}

    public int dajilwol(){return (this.s.ilosc_miejsc-this.s.ilosc_zajetych);}

    public int dajcene(){return this.cena;}

    public Date dajdate(){return this.data;}

    public Date dajgodz(){return this.godzina;}

}
