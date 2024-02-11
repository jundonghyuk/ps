
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String target = br.readLine();
        int idx = 0;
        int ret = 0;
        while (idx + target.length() <= line.length()) {
            boolean find = true;
            for (int i = idx; i < idx + target.length(); i++) {
                if (line.charAt(i) != target.charAt(i - idx)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                ret++;
                idx += target.length();
                continue;
            }
            idx++;
        }
        System.out.println(ret);
    }
}
