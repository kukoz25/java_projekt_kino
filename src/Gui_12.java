import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Gui_12 extends JFrame {
    private JLabel foto;
    private JTextField nr_sali;
    private JTextField il_m;
    private JButton wrocButton;
    private JPanel MainPanel;
    private JButton stworzSaleButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_12() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 400);
        this.setVisible(true);
        this.setTitle("Tworzenie");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stworzSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nr_sali.getText().isEmpty() || il_m.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Któraś rubryka zawiera niepoprawne dane, popraw je");
                } else {
                    boolean xd = false; // do sprawdzenia czy istnieje
                    String[] czy_jest = Wczytywanie.wczytaj("sale.csv");
                    for (int i = 0; i < czy_jest.length; i++) {
                        String data[] = czy_jest[i].split(";");
                        //System.out.println(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";");
                        if (data[0].equals(nr_sali.getText()) && data[1].equals(il_m.getText())) { // sprawdzanie czy istnieje dokładnie taki sam
                            xd = true;
                        }

                    }
                    if (xd == true) {
                        JOptionPane.showMessageDialog(null, "Taka sala istnieje, dodaj inną sale!");
                    } else {
                        List<String> dane = Arrays.asList(nr_sali.getText(), il_m.getText());
                        String[] dane_s = dane.stream().toArray(String[]::new);
                        //System.out.println("chuj");
                        Zapis.zapis_dopliku("sale.csv", dane_s);
                    }
                }
            }
        });
    }
}
