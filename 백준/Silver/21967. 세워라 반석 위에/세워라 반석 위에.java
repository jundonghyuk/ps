
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        List<Calculator> calculators = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            calculators.add(new Calculator(i, i + 2));
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < calculators.size(); j++) {
                calculators.get(j).calculate(data[i]);
            }
        }
        System.out.println(calculators.stream().mapToInt(Calculator::getMaxLen).max().getAsInt());
    }

    static class Calculator {
        public int maxLen = 0;
        public int len = 0;

        public int minBoundary;
        public int maxBoundary;

        public Calculator(int minBoundary, int maxBoundary) {
            this.minBoundary = minBoundary;
            this.maxBoundary = maxBoundary;
        }

        public void calculate(int num) {
            if (num >= minBoundary && num <= maxBoundary) {
                len++;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
        }

        public int getMaxLen() {
            return maxLen;
        }
    }
}
