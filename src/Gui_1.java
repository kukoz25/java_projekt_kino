import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_1 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JButton tworzenieButton;
    private JButton wczytywanieButton;
    private JButton wrocButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_1() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 340);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tworzenieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_1.super.setVisible(false);
                Gui_2 g = new Gui_2();
            }
        });
        wczytywanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_1.super.setVisible(false);
                Gui_4 g = new Gui_4();

            }
        });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_1.super.setVisible(false);
                Gui_8 g = new Gui_8();
            }
        });
    }
}
