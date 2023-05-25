import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N, M, K, cnt;
    static int[] parent;
    static ArrayList<Integer>[] map;
    static ArrayList<Integer> know = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new ArrayList[M];
        parent = new int[N + 1];

        // 부모 초기화
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 진실아는 사람들
        for (int i = 0; i < K; i++) {
            know.add(sc.nextInt());
        }

        // 진실아는 사람들 부모 통일
        for (int i = 1; i < K; i++) {
            int origin = know.get(0);
            parent[know.get(i)] = origin;
        }

        for (int i = 0; i < M; i++) {
            map[i] = new ArrayList<>();
            int num = sc.nextInt();
            int first = sc.nextInt();
            map[i].add(first);
            for (int j = 1; j < num; j++) {
                int temp = sc.nextInt();
                map[i].add(temp);
                union(first, temp);
            }
        }

        for (int i = 0; i < M; i++) {
            boolean mark = true;
            for (int num : map[i]) {
                if (!know.isEmpty() && find(know.get(0)) == find(num)) {
                    mark = false;
                    break;
                }
            }
            if(mark) {
                cnt++;
            }
        }

//        for(int i = 1; i <= N; i++) {
//            System.out.println(i +" : " + parent[i]);
//        }
        System.out.println(cnt);
    }

    static void union(int a, int b) {
        int paA = find(a);
        int paB = find(b);
        if(paA != paB) {
            parent[paA] = parent[paB];

        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
