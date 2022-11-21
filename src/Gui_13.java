import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Gui_13 extends JFrame {
    private JLabel foto;
    private JTable table1;
    private JButton wrocButton;
    private JButton usunWybranaSaleButton;
    private JPanel MainPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    Gui_13() {
        String[] p = Wczytywanie.wczytaj("sale.csv");
        List<Sala> sale = new ArrayList<Sala>();
        for (int i = 0; i < p.length; i++) {
            //System.out.println(p);
            String[] data = p[i].split(";");
            sale.add(new Sala(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }
        for (int i = 0; i < sale.size(); i++) {
            String d = sale.get(i).numer + ";" + sale.get(i).ilosc_miejsc;
            p[i] = d;
        }
        String dane[][] = Arraytostring.przeróbdane2(p);
        String k[] = {"Numer Sali", "Ilość miejsc"};
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
                Gui_13.super.setVisible(false);
                Gui_4 g = new Gui_4();
            }
        });
        usunWybranaSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = table1.getSelectedRow() + 1; //branie wybranej kolumny
                //System.out.println(r);
                Zapis.usuwanie("sale.csv", r);
                String[] p = Wczytywanie.wczytaj("sale.csv");
                List<Sala> sale = new ArrayList<Sala>();
                for (int i = 0; i < p.length; i++) {
                    //System.out.println(p);
                    String[] data = p[i].split(";");
                    sale.add(new Sala(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
                }
                for (int i = 0; i < sale.size(); i++) {
                    String d = sale.get(i).numer + ";" + sale.get(i).ilosc_miejsc;
                    p[i] = d;
                }
                String dane[][] = Arraytostring.przeróbdane2(p);
                String k[] = {"Numer Sali", "Ilość miejsc"};
                DefaultTableModel dtm = new DefaultTableModel(dane, k);
                table1.setModel(dtm);
            }
        });
    }
}

