import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_8 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ZALOGUJButton;
    private JButton nowyUżytkownikButton;

    Gui_8() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 370);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ZALOGUJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dane = Wczytywanie.wczytaj("login.csv");
                String login = textField1.getText().toString();
                String pass = passwordField1.getText().toString();
                String combined = login + ";" + pass;
//                System.out.println(combined);
//                System.out.println(dane);
                boolean xd = false;
                if (dane[0].equals(combined)) {
                    Gui_1 g = new Gui_1();
                    Gui_8.super.setVisible(false);
                    xd = true;
                } else {
                    for (int i = 1; i < dane.length; i++) {
                        if (dane[i].equals(combined)) {
                            Gui_8.super.setVisible(false);
                            Gui_9 g = new Gui_9();
                            xd = true;
                        }
                    }
                }
                if (xd == false) {
                    JOptionPane.showMessageDialog(null, "Brak takiego użytkownika!!!");
                }
            }

        });
        nowyUżytkownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_8.super.setVisible(false);
                Gui_15 g= new Gui_15();

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }
}
