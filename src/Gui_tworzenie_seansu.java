import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class Gui_tworzenie_seansu extends JFrame {
    private JPanel MainPanel;
    private JLabel foto;
    private JComboBox film;
    private JTextField podajKodTextField;
    private JComboBox sala;
    private JComboBox Data;
    private JComboBox cena;
    private JComboBox godzina;
    private JButton dodajSeansButton;
    private JButton wrocButton;

    private Map<Integer,String> mapka;

    private int i;

    private void createUIComponents() {
        // TODO: place custom component creation code here
        foto = new JLabel(new ImageIcon("kinoteka kukoza.png")); //dodajemy zdjęcie logo
    }

    public Gui_tworzenie_seansu() {
        this.i=0;
        this.mapka=new HashMap<>();
        this.createUIComponents();
        this.setContentPane(this.MainPanel);
        this.setSize(620, 390);
        this.setVisible(true);
        this.setTitle("Kinoteka Kukoza");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] p = Wczytywanie.wczytaj("filmy.csv");
        String[] s = Wczytywanie.wczytaj("sale.csv");
        List<Sala> sale = new ArrayList<Sala>();
        List<Film> filmy = new ArrayList<Film>();
        List<Date> daty = new ArrayList<Date>();
        List<Date> godziny = new ArrayList<Date>();
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //potrzebny, do formatowania dat
        daty.add(dzis);
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < 30; i++) {
            c.setTime(dzis);
            c.add(Calendar.DATE, 1);
            dzis = c.getTime();
            daty.add(dzis);
        }
        for (int i = 0; i < daty.size(); i++) {
            Data.addItem(formatter.format(daty.get(i)));
        }
        for (int i = 1; i < 51; i++) {
            cena.addItem(String.valueOf(i));
        }
        Date godz = new Date(2020, 10, 10, 0, 0); // zależało mi na 00:00
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm"); // potrzebny do formatowania godzin
        Calendar g = Calendar.getInstance(); // pomocnicza
        godziny.add(godz); // dodajemy początkową
        for (int i = 0; i < 47; i++) {
            g.setTime(godz);
            g.add(Calendar.MINUTE, 30); // seanse co 30 minut
            godz = g.getTime();
            godziny.add(godz);
        }
        for (int i = 0; i < godziny.size(); i++) {
            godzina.addItem(formatter2.format(godziny.get(i)));

        }


        dodajSeansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (podajKodTextField.getText().equals("Podaj kod")|| podajKodTextField.getText().isEmpty()) {
                        throw new CustomException("Kod nie może być pusty");
                    }
                    else {
                        try{
                        boolean xd = false; // do sprawdzenia czy istnieje
                        String[] czy_jest = Wczytywanie.wczytaj("seanse.csv");
                        for (int i = 0; i < czy_jest.length; i++) {
                            String data[] = czy_jest[i].split(";");
                            //System.out.println(data[0] + ";" + data[1] + ";" + data[2] + ";" + data[3] + ";");
                            if (data[0].equals(podajKodTextField.getText()) && data[1].equals(film.getSelectedItem().toString()) && data[2].equals(sala.getSelectedItem().toString()) && data[3].equals(cena.getSelectedItem().toString()) && data[4].equals(Data.getSelectedItem().toString()) && data[5].equals(godzina.getSelectedItem().toString())) { // sprawdzanie czy istnieje dokładnie taki sam
                                xd = true;
                            }

                        }
                        if (xd == true) {
                            throw new CustomException("Taki seans istnieje, dodaj inny seans!");
                        } else {
                            String m = "";
                            for (int i = 0; i < 25; i++) {
                                m = m + "0";
                            }
                            List<String> dane = Arrays.asList(podajKodTextField.getText(), film.getSelectedItem().toString(), sala.getSelectedItem().toString(), cena.getSelectedItem().toString(), Data.getSelectedItem().toString(), godzina.getSelectedItem().toString(), m);
                            String[] dane_s = dane.stream().toArray(String[]::new);
                            mapka.put(i, Arraytostring.zamiennastringa(dane_s));

                            //System.out.println("chuj");
                            Zapis.zapis_dopliku_mapa("seanse.csv", mapka);
                        }
                        }catch (CustomException ex)
                        {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (CustomException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        wrocButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gui_tworzenie_seansu.super.setVisible(false);
                Gui_2 g = new Gui_2();
            }
        });
    }
}

