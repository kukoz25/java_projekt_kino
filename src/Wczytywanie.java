import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wczytywanie {
    public Wczytywanie() {
        //pusty konstruktor
    }

    public static String[] wczytaj(String nazwa_plik) {
        String[] dane = {""};
        List<String> list = new ArrayList<String>(); // dynamiczna, bo nie znamy wielkosci kurde no
        File f = new File(nazwa_plik);
        if (f.isFile() && f.canRead()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(nazwa_plik));
                String line = reader.readLine();
                list.add(line);
                while (line != null) {
                    line = reader.readLine();
                    list.add(line);
                    //System.out.println(line);
                }
                list.remove(list.size() - 1);
                reader.close();
                dane = list.stream().toArray(String[]::new); // rzutowanie
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Pliku pewnie brakuje meh");
            }
        }
        //System.out.println(dane.length);
        return dane;
    }

    public static Map<Integer,String> wczytaj_mapa(String nazwa_plik)
    {
        Map<Integer,String> wcz = new HashMap<>();
        String[] data=wczytaj(nazwa_plik);
        for(int i=0;i< data.length;i++)
        {
            wcz.put(i,data[i]);
        }
        //System.out.println(wcz);
        return wcz;
    }


}
