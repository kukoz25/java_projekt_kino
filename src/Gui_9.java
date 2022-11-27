import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_9 extends JFrame {

    private JPanel MainPanel;
    private JLabel foto;
    private JButton pokazFilmyButton;
    private JButton pokazSeanseButton;
    private JButton wróćButton;

    public Gui_9() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 350);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pokazFilmyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_9.super.setVisible(false);
                Gui_sortowanie_filmow g = new Gui_sortowanie_filmow();
            }
        });
        wróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_9.super.setVisible(false);
                Gui_8 g = new Gui_8();
            }
        });
        pokazSeanseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_9.super.setVisible(false);
                Gui_sortowanie_seansow g = new Gui_sortowanie_seansow();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

}
