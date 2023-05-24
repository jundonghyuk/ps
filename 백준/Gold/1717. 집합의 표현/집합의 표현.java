import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList[] map;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        parent = new int[N+1];
        for(int i = 0; i <= N ; i++) {
            parent[i] = i;
        }
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String mark = st.nextToken();
            int source = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            if(mark.equals("0")) {
                union(source, target);
            } else {
                if (find(source) == find(target)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
    static void union(int a, int b) {
        int paA = find(a);
        int paB = find(b);

        set(paA, paB);
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }else {
            return find(parent[a]);
        }
    }

    static void set(int a, int b) {
        if(a == b) {
            return;
        } else if(a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
