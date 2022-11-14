import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui_5 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JTable table1;
    private JButton wróćButton;
    private JButton usuńWybranyFilmButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_5() {
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
        DefaultTableModel dtm = new DefaultTableModel(dane, k);
        table1.setModel(dtm);
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 450);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_5.super.setVisible(false);
                Gui_4 g = new Gui_4();
            }
        });
        usuńWybranyFilmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table1.getSelectedRow() + 1; //branie wybranej kolumny
                //System.out.println(r);
                Zapis.usuwanie("filmy.csv", r);
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
                DefaultTableModel dtm = new DefaultTableModel(dane, k);
                table1.setModel(dtm);
            }
        });
    }

}
