
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int n, q;
    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                set.add(i);
            }
        }
        int loc = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String line = br.readLine();
            if (line.equals("3")) {
                int ret = -1;
                if(set.isEmpty()) {
                    sb.append(ret + "\n");
                    continue;
                }

                if(set.contains(loc)) {
                    ret = 0;
                } else {
                    if(Objects.isNull(set.higher(loc))) {
                        ret = (n + set.first() - loc) % n;
                    } else {
                        ret = set.higher(loc) - loc;
                    }
                }
                sb.append(ret + "\n");
            } else if (line.startsWith("1")) {
                int pos = Integer.parseInt(line.split(" ")[1]) - 1;
                if (set.contains(pos)) {
                    set.remove(pos);
                } else {
                    set.add(pos);
                }
            } else {
                int step = Integer.parseInt(line.split(" ")[1]);
                loc = (loc + step) % n;
            }
        }
        System.out.println(sb);
    }
}
