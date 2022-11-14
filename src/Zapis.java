import javax.swing.*;
import java.io.*;

public class Zapis {
    public Zapis() {
        //pusty konstruktor
    }

    public static void zapis_dopliku(String nazwa_pliku, String[] dane) {
        try {
            Writer f1 = new BufferedWriter(new FileWriter(nazwa_pliku, true));
            for (int i = 0; i < dane.length; i++) {
                String tmp = dane[i];
                if (i == dane.length - 1) {
                    f1.write(tmp);
                } else f1.write(tmp + ";");
            }
            f1.write(System.lineSeparator());
            f1.close();
            JOptionPane.showMessageDialog(null, "Zapisano film do pliku " + nazwa_pliku);
            //System.exit(0);
        } catch (Exception g) {
            JOptionPane.showMessageDialog(null, "plik się popsuł czy coś tam");
        }
    }

    public static void usuwanie(String nazwa_pliku, int nr_linii) {
        String tmp = "temp.txt";
        File stary = new File(nazwa_pliku);
        File nowy = new File(tmp);
        int linia = 0;
        String linia_biez;

        try {
            FileWriter fw = new FileWriter(tmp, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            FileReader fr = new FileReader(nazwa_pliku);
            BufferedReader br = new BufferedReader(fr);
            while ((linia_biez = br.readLine()) != null) {
                linia++;
                if (nr_linii != linia) {
                    pw.println(linia_biez);

                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();
            stary.delete();
            File db = new File(nazwa_pliku);
            nowy.renameTo(db);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}