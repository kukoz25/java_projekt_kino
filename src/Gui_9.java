import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_9 extends JFrame {

    private JPanel MainPanel;
    private JLabel foto;
    private JButton pokazFilmyButton;
    private JButton pokazSeanseButton;
    private JButton pokazReperturarButton;
    private JButton kupBiletButton;

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
                Gui_10 g = new Gui_10();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

}
