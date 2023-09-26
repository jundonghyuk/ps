
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Character[][] map = new Character[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] charArray = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArray[j];
            }
        }

        // 증감
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                Map<Character, Integer> frequency = new HashMap<>();
                int count = 0;
                for (int row = i; row < map.length; row = row + K) {
                    for (int col = j; col < map[0].length; col = col + K) {
                        count++;
                        frequency.put(map[row][col], frequency.getOrDefault(map[row][col], 0) + 1);
                    }
                }
                Character maxKey = frequency.keySet()
                        .stream()
                        .max(Comparator.comparingInt(frequency::get))
                        .get();
                sum += (count - frequency.get(maxKey));
                for (int row = i; row < map.length; row = row + K) {
                    for (int col = j; col < map[0].length; col = col + K) {
                        map[row][col] = maxKey;
                    }
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(sum);
//        bw.write(sum);
//        bw.write("\n");
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j <map[i].length; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
