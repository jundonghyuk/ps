
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int ret = 0;

    public static void main(String[] args) throws Exception {
//        List<Ingredient> ingredients = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Ingredient[] ingredients = new Ingredient[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            int notNeed = Integer.parseInt(st.nextToken());
            ingredients[i] = new Ingredient(s, limit, notNeed);
        }

        long l = 0;
        long r = Integer.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < ingredients.length; i++) {
                Ingredient ingredient = ingredients[i];
                if (ingredient.noNeed) {
                    long calculate = ingredient.calculate(mid);
                    pq.add(calculate);
                    sum += calculate;
                } else {
                    sum += ingredient.calculate(mid);
                }
            }
            int count = K;
            while (!pq.isEmpty()) {
                if (count > 0) {
                    count--;
                    sum -= pq.poll();
                } else {
                    break;
                }
            }

            if (sum > G) {
                r = mid - 1;
            } else if (sum <= G) {
                l = mid + 1;
            }
        }
        bw.write(String.valueOf(r));
        bw.flush();
    }

    static class Ingredient {
        long s;
        long limit;
        boolean noNeed;

        public Ingredient(long s, long limit, int noNeed) {
            this.s = s;
            this.limit = limit;
            this.noNeed = noNeed == 1;
        }

        public long calculate(long day) {
            return s * Math.max(1, day - limit);
        }
    }
}
