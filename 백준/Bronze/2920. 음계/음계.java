
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int asc = 0;
        int dec = 0;
        int prev = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < prev) {
                dec++;
            } else {
                asc++;
            }
            prev = num;
        }
        if (asc == 0) {
            System.out.println("descending");
        } else if (dec == 0) {
            System.out.println("ascending");
        } else {
            System.out.println("mixed");
        }
    }
}
