
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String species = sc.nextLine();
            cnt++;
            if (map.containsKey(species)) {
                map.put(species, map.get(species) + 1);
            } else {
                map.put(species, 1);
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.naturalOrder());

        for (String s : list) {
            int frequency = map.get(s);
            double rate = Math.round((double) frequency / (double) cnt * 1000000) / (double) 10000;
            System.out.println(s + " " + String.format("%.4f", rate));
        }
    }
}
