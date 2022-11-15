import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Gui_3 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JTextField nazwa_filmu;
    private JLabel nazwa;
    private JComboBox gatunek;
    private JComboBox rok;
    private JComboBox dlugosc;
    private JButton dodaj;
    private JButton zakończDodawanieButton;
    private JButton wróćButton;


    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_3() {
        this.createUIComponents();
        String[] gatunek_l = {"gatunek", "komedia", "thriller", "horror", "dramat", "animacja", "kryminał", "musical", "sci-fi"}; // dane do comboboxa
        for (int i = 0; i < gatunek_l.length; i++) {
            gatunek.addItem(gatunek_l[i]); // dodanie do comboboxa
        }
        rok.addItem("rok");
        for (int i = 2023; i > 1895; i--) {
            rok.addItem(String.valueOf(i));
        }
        dlugosc.addItem("długość");
        for (int i = 240; i <= 1; i--) {
            dlugosc.addItem(String.valueOf(i));
        }
        this.setContentPane(this.MainPanel);
        this.setSize(620, 400);
        this.setVisible(true);
        this.setTitle("Tworzenie Filmu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nazwa_filmu.getText().isEmpty() || gatunek.getSelectedItem().toString() == "gatunek" || rok.getSelectedItem().toString() == "rok" || dlugosc.getSelectedItem().toString() == "długość") {
                    JOptionPane.showMessageDialog(null, "Któraś rubryka zawiera niepoprawne dane, popraw je");
                } else {
                    boolean xd = false; // do sprawdzenia czy istnieje
                    String[] czy_jest = Wczytywanie.wczytaj("filmy.csv");
                    for (int i = 0; i < czy_jest.length; i++) {
                        String data[] = czy_jest[i].split(";");
                        //System.out.println(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";");
                        if (data[0].equals(nazwa_filmu.getText()) && data[1].equals(gatunek.getSelectedItem().toString()) && data[2].equals(rok.getSelectedItem().toString()) && data[3].equals(dlugosc.getSelectedItem().toString())) { // sprawdzanie czy istnieje dokładnie taki sam
                            xd = true;
                        }

                    }
                    if (xd == true) {
                        JOptionPane.showMessageDialog(null, "Taki film istnieje, dodaj inny film!");
                    } else {
                        List<String> dane = Arrays.asList(nazwa_filmu.getText(), gatunek.getSelectedItem().toString(), rok.getSelectedItem().toString(), dlugosc.getSelectedItem().toString());
                        String[] dane_s = dane.stream().toArray(String[]::new);
                        //System.out.println("chuj");
                        Zapis.zapis_dopliku("filmy.csv", dane_s);
                    }
                }
            }
        });
        zakończDodawanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_1 g = new Gui_1();
                Gui_3.super.setVisible(false);
            }
        });
        wróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_3.super.setVisible(false);
                Gui_2 g = new Gui_2();
            }
        });
    }
}
