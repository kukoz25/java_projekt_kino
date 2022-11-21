import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Gui_sortowanie_filmow extends JFrame {
    private JLabel foto;
    private JTable table1;
    private JButton posortujPoRokuButton;
    private JButton wrocButton;
    private JPanel MainPanel;
    private JButton posortujPoDlugościButton;
    private JButton posortuj;
    private JCheckBox odwrotnieCheckBox;
    private JComboBox comboBox1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_sortowanie_filmow() {
        String[] p = Wczytywanie.wczytaj("filmy.csv");
        List<Film> filmy = new ArrayList<Film>();
        for (int i = 0; i < p.length; i++) {
            //System.out.println(p);
            String[] data = p[i].split(";");
            filmy.add(new Film(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
        for (int i = 0; i < filmy.size(); i++) {
            String d = filmy.get(i).nazwa + ";" + filmy.get(i).gatunek + ";" + filmy.get(i).rok + ";" + filmy.get(i).dlugosc;
            p[i] = d;
        }
        String dane[][] = Arraytostring.przeróbdane(p);
        String k[] = {"Tytuł", "Gatunek", "Rok", "Długość"};
        for (int i = 0; i < k.length; i++) {
            comboBox1.addItem(k[i]);
        }
        DefaultTableModel dtm = new DefaultTableModel(dane, k);
        table1.setModel(dtm);
        table1.setDefaultEditor(Object.class, null);
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 460);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_sortowanie_filmow.super.setVisible(false);
                Gui_9 g = new Gui_9();
            }
        });
        posortuj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] p = Wczytywanie.wczytaj("filmy.csv");
                int typ = 0;
                String k[] = {"Tytuł", "Gatunek", "Rok", "Długość"};
                String wybrany = comboBox1.getSelectedItem().toString();
                boolean check = odwrotnieCheckBox.isSelected();
                if (wybrany.equals(k[0]))
                    typ = 1;
                if (wybrany.equals(k[1]))
                    typ = 2;
                if (wybrany.equals(k[2]))
                    typ = 3;
                if (wybrany.equals(k[3]))
                    typ = 4;
                Map<Integer, String> map = sortujfilmy(typ, check);
                List<Film> filmy = new ArrayList<Film>();
                String tmp = "";
                String[] data;
                //System.out.println(map.size());
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    tmp = entry.getValue();
                    data = tmp.split(";");
                    filmy.add(new Film(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
                }
                for (int i = 0; i < filmy.size(); i++) {
                    String d = filmy.get(i).nazwa + ";" + filmy.get(i).gatunek + ";" + filmy.get(i).rok + ";" + filmy.get(i).dlugosc;
                    p[i] = d;
                }
                String dane[][] = Arraytostring.przeróbdane(p);
                DefaultTableModel dtm = new DefaultTableModel(dane, k);
                table1.setModel(dtm);
                table1.setDefaultEditor(Object.class, null);
            }
        });
    }

    public static Map<Integer, String> sortujfilmy(int typ, boolean od) {
        Map<Integer, String> mapa = Wczytywanie.wczytaj_mapa("filmy.csv");
        String tmp = "";
        String[] data;
        List<Film> filmy = new ArrayList<Film>();
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            tmp = entry.getValue();
            data = tmp.split(";");
            filmy.add(new Film(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
        if (typ == 1 && od == false) {
            filmy.sort(Comparator.comparing(Film::dajnazwe));
        }
        if (typ == 1 && od == true) {
            filmy.sort(Comparator.comparing(Film::dajnazwe).reversed());
        }
        if (typ == 2 && od == false) {
            filmy.sort(Comparator.comparing(Film::dajgatunek));
        }
        if (typ == 2 && od == true) {
            filmy.sort(Comparator.comparing(Film::dajgatunek).reversed());
        }
        if (typ == 3 && od == false) {
            filmy.sort(Comparator.comparing(Film::dajrok));
        }
        if (typ == 3 && od == true) {
            filmy.sort(Comparator.comparing(Film::dajrok).reversed());
        }
        if (typ == 4 && od == false) {
            filmy.sort(Comparator.comparing(Film::dajdl));
        }
        if (typ == 4 && od == true) {
            filmy.sort(Comparator.comparing(Film::dajdl).reversed());
        }
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < filmy.size(); i++) {
            String d = filmy.get(i).nazwa + ";" + filmy.get(i).gatunek + ";" + filmy.get(i).rok + ";" + filmy.get(i).dlugosc;
            //System.out.println(d);
            map.put(i, d);
        }
        //System.out.println(filmy.size());
        return map;
    }
}
