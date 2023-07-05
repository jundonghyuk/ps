import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List<Integer> lope = new ArrayList<>();
    static int weight = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            lope.add(sc.nextInt());
        }
        Collections.sort(lope);
        int cnt = 1;
        for(int i = N - 1; i >= 0; i--) {
            Integer temp = lope.get(i);
            weight = Math.max(weight, temp * cnt);
            cnt++;
        }

        System.out.println(weight);
    }
}
