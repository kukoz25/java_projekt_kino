import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Gui_15 extends JFrame{
    private JPanel MainPanel;
    private JLabel foto;
    private JTextField user;
    private JPasswordField passwordField1;
    private JButton stwórzButton;
    private JButton wróćButton;

    public Gui_15() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stwórzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.getText().isEmpty() || passwordField1.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Jakaś wartość pusta");
                }
                else
                {
                    List<String> dane = Arrays.asList(user.getText(),passwordField1.getText());
                    String[] dane_s = dane.stream().toArray(String[]::new);
                    Zapis.zapis_dopliku("login.csv", dane_s);
                }
            }
        });
        wróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_15.super.setVisible(false);
                Gui_8 g = new Gui_8();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }
}
