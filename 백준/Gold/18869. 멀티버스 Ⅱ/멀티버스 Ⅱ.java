
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/*
        100 * 10000 * log(10000)  = 400만
 */
public class Main {

    static int n, m;
    static int[][] planets;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        planets = new int[m][n];
        list = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder stringBuilder = new StringBuilder();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
                planets[i][j] = num;
            }
            list[i] = new ArrayList<>(set);
            Collections.sort(list[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                planets[i][j] = Collections.binarySearch(list[i], planets[i][j]);
            }
        }

        long ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (Arrays.equals(planets[i], planets[j])) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}
