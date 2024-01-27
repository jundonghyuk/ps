
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        boolean zero = false;
        int rest = 0;
        int[] arr = new int[10];
        for (char ch : line.toCharArray()) {
            if (ch == '0') {
                zero = true;
            }
            rest = (rest + (ch - '0')) % 3;
            arr[ch - '0']++;
        }

        if (zero && rest == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
            return;
        }
        System.out.println(-1);
    }
}
