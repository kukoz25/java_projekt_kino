import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class Gui_sortowanie_seansow extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JTable table1;
    private JButton wrocButton;
    private JButton kupBiletButton;
    private JCheckBox odwrotnieCheckBox;
    private JComboBox comboBox1;
    private JButton sortujButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    Gui_sortowanie_seansow() {
        String[] p = Wczytywanie.wczytaj("seanse.csv");
        Map<Integer, String> mp = Wczytywanie.wczytaj_mapa("seanse.csv");
        List<Seans> seanse = new ArrayList<Seans>();
        String tmp = "";
        String[] data;
        //System.out.println(p);
        for (Map.Entry<Integer, String> entry : mp.entrySet()) {
            tmp = entry.getValue();
            data = tmp.split(";");
            seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]));
        }
        SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");        SimpleDateFormat h = new SimpleDateFormat("HH:mm");
        //System.out.println(seanse.get(0).godzina);
        for (int i = 0; i < seanse.size(); i++) {
            String d = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).f.gatunek + ";" + seanse.get(i).f.rok + ";" + seanse.get(i).f.dlugosc + ";" + seanse.get(i).s.numer + ";" + Integer.toString(seanse.get(i).s.ilosc_miejsc - seanse.get(i).s.ilosc_zajetych) + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina);
            p[i] = d;
        }
        String dane[][] = Arraytostring.przeróbdane4(p);
        String k[] = {"Kod Seansu", "Nazwa filmu", "Gatunek", "Rok", "Długość", "Sala", "Ilość wolnych", "Cena", "Data", "Godzina"};
        for (int i = 0; i < k.length; i++) {
            comboBox1.addItem(k[i]);
        }
        DefaultTableModel dtm = new DefaultTableModel(dane, k);
        table1.setModel(dtm);
        table1.setDefaultEditor(Object.class, null);
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 450);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_sortowanie_seansow.super.setVisible(false);
                Gui_9 g = new Gui_9();
            }
        });

        kupBiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table1.getSelectedRow();
                Gui_sortowanie_seansow.super.setVisible(false);
                Gui_kupowanie g = new Gui_kupowanie(r);
            }
        });
        sortujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("chuj");
                String[] p = Wczytywanie.wczytaj("seanse.csv");
                String[] p1 = Wczytywanie.wczytaj("seanse.csv");
                int typ = 0;
                String k[] = {"Kod Seansu", "Nazwa filmu", "Gatunek", "Rok", "Długość", "Sala", "Ilość wolnych", "Cena", "Data", "Godzina"};
                String wybrany = comboBox1.getSelectedItem().toString();
                boolean check = odwrotnieCheckBox.isSelected();
                if (wybrany.equals(k[0])) typ = 1;
                if (wybrany.equals(k[1])) typ = 2;
                if (wybrany.equals(k[2])) typ = 3;
                if (wybrany.equals(k[3])) typ = 4;
                if (wybrany.equals(k[4])) typ = 5;
                if (wybrany.equals(k[5])) typ = 6;
                if (wybrany.equals(k[6])) typ = 7;
                if (wybrany.equals(k[7])) typ = 8;
                if (wybrany.equals(k[8])) typ = 9;
                if (wybrany.equals(k[9])) typ = 10;
                Map<Integer, String> map = sortujseanse(typ, check);
                List<Seans> seanse = new ArrayList<Seans>();
                String tmp = "";
                String[] data;
                //System.out.println(map.size());
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    tmp = entry.getValue();
                    data = tmp.split(";");
                    //System.out.println(tmp);
                    //Seans(String k, String nazwa_f,int nr_sali,int c,String d, String g, String miejsca)
                    seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[5]), Integer.parseInt(data[7]), data[8], data[9], data[10]));
                }
                for (int i = 0; i < seanse.size(); i++) {
                    String d1 = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).s.numer + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina) + ";" + seanse.get(i).m;
                    String d = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).f.gatunek + ";" + seanse.get(i).f.rok + ";" + seanse.get(i).f.dlugosc + ";" + seanse.get(i).s.numer + ";" + Integer.toString(seanse.get(i).s.ilosc_miejsc - seanse.get(i).s.ilosc_zajetych) + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina);
                    //System.out.println(d1);
                    p[i] = d;
                    p1[i] = d1;
                }
                File myObj = new File("seanse.csv");
                myObj.delete();
                String[] zmienna;
                for (int i = 0; i < p1.length; i++) {
                    zmienna = p1[i].split(";");
                    //System.out.println(d1);
                    Zapis.zapis_dopliku("seanse.csv", zmienna);
                }
                String dane[][] = Arraytostring.przeróbdane4(p);
                DefaultTableModel dtm = new DefaultTableModel(dane, k);
                table1.setModel(dtm);
                table1.setDefaultEditor(Object.class, null);
            }
        });
    }

    public static Map<Integer, String> sortujseanse(int typ, boolean od) {
        String tmp = "";
        String[] data;
        Map<Integer, String> mapa = Wczytywanie.wczytaj_mapa("seanse.csv");
        List<Seans> seanse = new ArrayList<Seans>();
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            tmp = entry.getValue();
            data = tmp.split(";");
            seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]));
        }
        String k[] = {"Kod Seansu", "Nazwa filmu", "Gatunek", "Rok", "Długość", "Sala", "Ilość wolnych", "Cena", "Data", "Godzina"};
        if (typ == 1 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajkod));
        }
        if (typ == 1 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajkod).reversed());
        }
        if (typ == 2 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajnazwe));
        }
        if (typ == 2 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajnazwe).reversed());
        }
        if (typ == 3 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajgat));
        }
        if (typ == 3 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajgat).reversed());
        }
        if (typ == 4 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajrok));
        }
        if (typ == 4 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajrok).reversed());
        }
        if (typ == 5 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajdl));
        }
        if (typ == 5 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajdl).reversed());
        }
        if (typ == 6 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajnrsali));
        }
        if (typ == 6 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajnrsali).reversed());
        }
        if (typ == 7 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajilwol));
        }
        if (typ == 7 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajilwol).reversed());
        }
        if (typ == 8 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajcene));
        }
        if (typ == 8 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajcene).reversed());
        }
        if (typ == 9 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajdate));
        }
        if (typ == 9 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajdate).reversed());
        }
        if (typ == 10 && od == false) {
            seanse.sort(Comparator.comparing(Seans::dajgodz));
        }
        if (typ == 10 && od == true) {
            seanse.sort(Comparator.comparing(Seans::dajgodz).reversed());
        }
        SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat h = new SimpleDateFormat("HH:mm");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < seanse.size(); i++) {
            String d = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).f.gatunek + ";" + seanse.get(i).f.rok + ";" + seanse.get(i).f.dlugosc + ";" + seanse.get(i).s.numer + ";" + Integer.toString(seanse.get(i).s.ilosc_miejsc - seanse.get(i).s.ilosc_zajetych) + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina) + ";" + seanse.get(i).m;
            //System.out.println(d);
            map.put(i, d);
        }
        //System.out.println(seanse.size());
        return map;
    }

}
