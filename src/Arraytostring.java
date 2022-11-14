import java.util.ArrayList;
import java.util.List;

public class Arraytostring {
    public Arraytostring() {
    }

    public static String[][] przeróbdane(String[] dane) {
        List<List<String>> array = new ArrayList<List<String>>();

        for (int i = 0; i < dane.length; i++) {
            List<String> tmp = new ArrayList<String>();
            //System.out.println(dane[i]);
            String[] data = dane[i].split(";");
//            for(int j=0;j<data.length;j++)
//            {
//                System.out.println(data[j]);
//            }
//            System.out.println(data);
            tmp.add(data[0]);
            tmp.add(data[1]);
            tmp.add(data[2]);
            tmp.add(data[3]);
            array.add(tmp);
        }
//       for(int i=0;i<array.size();i++)
//       {
//           System.out.println(array.get(i).get(0));
//       }
        String data[][] = array.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new); // rzutowanie na tablice z dynamicznej dwuwymiarowej na statyczną
        //System.out.println(data.length);
        return data;
    }
}
