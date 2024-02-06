
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String start = st.nextToken();
        String end = st.nextToken();
        String finish = st.nextToken();

        HashSet<String> prev = new HashSet<>();
        HashSet<String> next = new HashSet<>();

        String line = "";
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] split = line.split(" ");
            if(split[0].compareTo(start) <= 0) {
                prev.add(split[1]);
            } else if(split[0].compareTo(end) >=0 && split[0].compareTo(finish) <= 0) {
                next.add(split[1]);
            }
        }
        long ret = 0;
        for (String s : prev) {
            if(next.contains(s)) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}
