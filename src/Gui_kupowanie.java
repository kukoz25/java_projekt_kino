import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Gui_kupowanie{

    Gui_kupowanie(int r) {
        String[] p = Wczytywanie.wczytaj("seanse.csv");
        List<Seans> seanse = new ArrayList<Seans>();
        for (int i = 0; i < p.length; i++) {
            //System.out.println(p);
            String[] data = p[i].split(";");
            seanse.add(new Seans(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], data[5], data[6]));
        }
        ArrayList<JCheckBox> b = new ArrayList<JCheckBox>();
        int[][] tab = new int[5][5];
        int tmp = 0;
        char tmp2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp2 = seanse.get(r).m.charAt(tmp);
                tab[i][j] = Character.getNumericValue(tmp2);
                b.add(new JCheckBox(Integer.toString(tmp + 1)));
                if (tab[i][j] == 1) {
                    b.get(tmp).setSelected(true);
                    b.get(tmp).setEnabled(false);
                }
                //System.out.println(Integer.toString(zajete));
                tmp++;

            }
        }
        JFrame frame = new JFrame();
        // JPanel panel = new JPanel();
        frame.setSize(600, 450);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel foto = new JLabel(new ImageIcon("kinoteka kukoza.png"));
        Dimension size = foto.getPreferredSize();
        foto.setBounds(0, 0, size.width, size.height);
        //panel.add(foto);
        frame.add(foto);
        JLabel o = new JLabel("Wybierz wolne miejsca");
        size = o.getPreferredSize();
        o.setBounds(150, 160, size.width, size.height);
        frame.add(o);
        JLabel e = new JLabel("EKRAN");
        size = e.getPreferredSize();
        e.setBounds(150, 230, size.width+15, size.height);
        frame.add(e);
        JLabel ilosc_z = new JLabel(Integer.toString(seanse.get(r).s.ilosc_zajetych));
        size = ilosc_z.getPreferredSize();
        ilosc_z.setBounds(350, 270, size.width, size.height);
        frame.add(ilosc_z);
        JLabel ilosc_zaj = new JLabel("Ilość zajętych miejsc");
        size = ilosc_zaj.getPreferredSize();
        ilosc_zaj.setBounds(350, 250, size.width, size.height);
        frame.add(ilosc_zaj);
        JLabel ilosc_w = new JLabel(Integer.toString(seanse.get(r).s.ilosc_miejsc - seanse.get(r).s.ilosc_zajetych));
        size = ilosc_w.getPreferredSize();
        ilosc_w.setBounds(350, 310, size.width, size.height);
        frame.add(ilosc_w);
        JLabel ilosc_wol = new JLabel("Ilość wolnych");
        size = ilosc_wol.getPreferredSize();
        ilosc_wol.setBounds(350, 290, size.width, size.height);
        frame.add(ilosc_wol);
        JButton kup = new JButton("Kup Bilet");
        size = kup.getPreferredSize();
        kup.setBounds(350, 340, size.width+15, size.height);
        frame.add(kup);
        JButton wroc = new JButton("Wróć");
        size = wroc.getPreferredSize();
        wroc.setBounds(350, 370, size.width, size.height);
        frame.add(wroc);
        int x = 80, y = 270;
        for (int i = 0; i < 25; i++) {
            size = b.get(i).getPreferredSize();
            b.get(i).setBounds(x, y, size.width, size.height);
            frame.add(b.get(i));
            x = x + 45;
            if (i == 4) {
                y = y + 25;
                x = 80;
            }
            if (i == 9) {
                y = y + 25;
                x = 80;
            }
            if (i == 14) {
                y = y + 25;
                x = 80;
            }
            if (i == 19) {
                y = y + 25;
                x = 80;
            }
        }
        kup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String g = "";
                String kupione="";
                int tmp = 0;
                for (int i = 0; i < b.size(); i++) {
                    if (b.get(i).isSelected()) {
                        tmp++;
                        g += "1";
                        if(b.get(i).isEnabled())
                        {
                            kupione+=Integer.toString(i+1) + " ";
                        }
                    } else g += "0";
                }
                //System.out.println(g);
                SimpleDateFormat formatterdata = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat formattergodzina = new SimpleDateFormat("HH:mm");
                String old = seanse.get(r).kod + ";" + seanse.get(r).f.nazwa + ";" + seanse.get(r).s.numer + ";" + seanse.get(r).cena + ";" + formatterdata.format(seanse.get(r).data) + ";" + formattergodzina.format(seanse.get(r).godzina) + ";" + seanse.get(r).m;
                String neww = seanse.get(r).kod + ";" + seanse.get(r).f.nazwa + ";" + seanse.get(r).s.numer + ";" + seanse.get(r).cena + ";" + formatterdata.format(seanse.get(r).data) + ";" + formattergodzina.format(seanse.get(r).godzina) + ";" + g;
                //System.out.println(old);
                JOptionPane.showMessageDialog(null, "Wybrano miejsca " + kupione);
                Zapis.podmiana("seanse.csv", old, neww);
                Gui_sortowanie_seansow h=new Gui_sortowanie_seansow();
                frame.setVisible(false);
            }
        });
        wroc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Gui_sortowanie_seansow h=new Gui_sortowanie_seansow();
            }
        });
    }
}


