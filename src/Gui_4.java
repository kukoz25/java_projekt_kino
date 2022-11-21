import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_4 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JButton pokazFilmyButton;
    private JButton pokazSaleButton;
    private JButton pokazSeanseButton;
    private JButton wrocButton;

    public Gui_4() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 350);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pokazFilmyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_4.super.setVisible(false);
                Gui_5 g = new Gui_5();
            }
        });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_4.super.setVisible(false);
                Gui_1 g = new Gui_1();
            }
        });
        pokazSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_4.super.setVisible(false);
                Gui_13 g = new Gui_13();
            }
        });
        pokazSeanseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_4.super.setVisible(false);
                Gui_14 g = new Gui_14();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }
}
