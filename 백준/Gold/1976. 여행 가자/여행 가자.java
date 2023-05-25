import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int map[][];
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 1][N + 1];
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int target = sc.nextInt();
                if(target == 1 && i >= j) {
                    union(i, j);
                }
            }
        }
        int sync = 0;
        for(int i = 0; i <M;i++) {
            int target = sc.nextInt();
            if(i == 0) {
                sync = find(target);
                continue;
            } else {
                if(sync != find(target)) {
                    System.out.println("NO");
                    for(int  k = 1; k<=3 ;k++) {
//                        System.out.println(parent[k]);
                    }
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b) {
        int paA = find(a);
        int paB = find(b);
//        System.out.println(a + "  " + b);
        parent[paA] = paB;
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
