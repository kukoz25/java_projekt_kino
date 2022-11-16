import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Gui_11 extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JComboBox film;
    private JTextField podajKodTextField;
    private JComboBox sala;
    private JComboBox data;

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
        String[] s = Wczytywanie.wczytaj("sale.csv");
        List<Sala> sale = new ArrayList<Sala>();
        List<Film> filmy = new ArrayList<Film>();
        List<Date> daty = new ArrayList<Date>();
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

        for (int i = 0; i < s.length; i++) {
            //System.out.println(p);
            String[] data = s[i].split(";");
            sale.add(new Sala(Integer.parseInt(data[0]), Integer.parseInt(data[1])));
        }
        for (int i = 0; i < sale.size(); i++) {
            String d = String.valueOf(sale.get(i).numer);
            s[i] = d;
        }

        for (int i = 0; i < s.length; i++) {
            sala.addItem(s[i]);
        }

        Date dzis = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        daty.add(dzis);
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            c.setTime(dt);
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            daty.add(dt);
        }
        for (int i = 0; i < daty.size(); i++) {
            data.addItem(formatter.format(daty.get(i)));
        }


    }
}
