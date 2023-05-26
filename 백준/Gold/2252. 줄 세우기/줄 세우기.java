import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] rules;
    static int[] orders;
    static boolean[] visited;
    static StringJoiner sj = new StringJoiner(" ");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        rules = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            rules[i] = new ArrayList<>();
        }

        orders = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int prev = sc.nextInt();
            int next = sc.nextInt();
            rules[prev].add(next);
            orders[next]++;
        }

        while (true) {
            boolean exit = true;
            for (int i = 1; i < orders.length; i++) {
                if (orders[i] == 0 && !visited[i]) {
                    exit = false;
                    sj.add(String.valueOf(i));
                    visited[i] = true;
                    for (int target : rules[i]) {
                        orders[target]--;
                    }
                }
            }
            if (exit) {
                break;
            }
        }
        System.out.println(sj.toString());
    }
}
