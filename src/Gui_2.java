import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_2 extends JFrame {
    private JLabel foto;
    private JPanel MainPanel;
    private JButton TworzFilm;  // guziczek od tworzenia filmu
    private JButton TworzSeans;  // guziczek od tworzenia senasu
    private JButton TworzRepetuar; // guziczek od tworzenia repertuaru
    private JButton wróćButton;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_2() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 400);
        this.setVisible(true);
        this.setTitle("Tworzenie");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TworzFilm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_2.super.setVisible(false);
                Gui_3 g = new Gui_3();

            }
        });
        wróćButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_2.super.setVisible(false);
                Gui_1 g = new Gui_1();
            }
        });
        TworzSeans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_2.super.setVisible(false);
                Gui_11 g = new Gui_11();
            }
        });
        TworzRepetuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_2.super.setVisible(false);
                Gui_12 g= new Gui_12();
            }
        });
    }
}

