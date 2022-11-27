import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Gui_14 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JTable table1;
    private JButton wrocButton;
    private JButton usunWybranySeansButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    Gui_14() {
        String[] p = Wczytywanie.wczytaj("seanse.csv");
        List<Seans> seanse = new ArrayList<Seans>();
        for (int i = 0; i < p.length; i++) {
            //System.out.println(p);
            String[] data = p[i].split(";");
            seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]));
        }
        SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat h = new SimpleDateFormat("HH-mm");
        //System.out.println(seanse.get(0).godzina);
        for (int i = 0; i < seanse.size(); i++) {
            String d = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).f.gatunek + ";" + seanse.get(i).f.rok + ";" + seanse.get(i).f.dlugosc + ";" + seanse.get(i).s.numer + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina);
            p[i] = d;
        }
        String dane[][] = Arraytostring.przeróbdane3(p);
        String k[] = {"Kod Seansu", "Nazwa filmu", "Gatunek", "Rok", "Długość", "Sala", "Cena", "Data", "Godzina"};
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
                Gui_14.super.setVisible(false);
                Gui_4 g = new Gui_4();
            }
        });

        usunWybranySeansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table1.getSelectedRow() + 1; //branie wybranej kolumny
                //System.out.println(r);
                Zapis.usuwanie("seanse.csv", r);
                String[] p = Wczytywanie.wczytaj("seanse.csv");
                List<Seans> seanse = new ArrayList<Seans>();
                for (int i = 0; i < p.length; i++) {
                    //System.out.println(p);
                    String[] data = p[i].split(";");
                    seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]));
                }
                SimpleDateFormat dat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat h = new SimpleDateFormat("HH-mm");
                //System.out.println(seanse.get(0).godzina);
                for (int i = 0; i < seanse.size(); i++) {
                    String d = seanse.get(i).kod + ";" + seanse.get(i).f.nazwa + ";" + seanse.get(i).f.gatunek + ";" + seanse.get(i).f.rok + ";" + seanse.get(i).f.dlugosc + ";" + seanse.get(i).s.numer + ";" + seanse.get(i).cena + ";" + dat.format(seanse.get(i).data) + ";" + h.format(seanse.get(i).godzina);
                    p[i] = d;
                }
                String dane[][] = Arraytostring.przeróbdane3(p);
                String k[] = {"Kod Seansu", "Nazwa filmu", "Gatunek", "Rok", "Długość", "Sala", "Cena", "Data", "Godzina"};
                DefaultTableModel dtm = new DefaultTableModel(dane, k);
                table1.setModel(dtm);
                table1.setDefaultEditor(Object.class, null);
            }
        });
    }

}
