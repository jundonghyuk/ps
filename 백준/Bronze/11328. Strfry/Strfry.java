
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            char[] firstLetters = new char[26];
            char[] secondLetters = new char[26];

            for (char ch : first.toCharArray()) {
                firstLetters[ch - 'a']++;
            }
            for (char ch : second.toCharArray()) {
                secondLetters[ch - 'a']++;
            }

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (firstLetters[i] != secondLetters[i]) {
                    sb.append("Impossible");
                    sb.append("\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append("Possible");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
