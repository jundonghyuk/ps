
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String FIRST;
    static String SECOND;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FIRST = br.readLine();
        SECOND = br.readLine();

        char[] first = FIRST.toCharArray();
        char[] second = SECOND.toCharArray();

        int[] firstLetter = new int[26];
        int[] secondLetter = new int[26];

        for (char ch : first) {
            firstLetter[ch - 'a']++;
        }
        for (char ch : second) {
            secondLetter[ch - 'a']++;
        }

        int ret = 0;
        for (int i = 0; i < 26; i++) {
            ret += Math.abs(firstLetter[i] - secondLetter[i]);
        }
        System.out.println(ret);
    }
}
