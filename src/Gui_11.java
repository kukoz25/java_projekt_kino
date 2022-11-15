import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Gui_11 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JComboBox film;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_11() {
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 350);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] p = Wczytywanie.wczytaj("filmy.csv");
        List<Film> filmy = new ArrayList<Film>();
        for (int i = 0; i < p.length; i++) {
            //System.out.println(p);
            String[] data = p[i].split(";");
            filmy.add(new Film(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
        }
        for (int i = 0; i < filmy.size(); i++) {
            String d = filmy.get(i).nazwa;
            p[i] = d;
        }

        for (int i = 0; i < p.length; i++) {
            film.addItem(p[i]);
        }


    }
}
