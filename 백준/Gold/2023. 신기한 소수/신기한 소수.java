import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        getResult(2, N-1);
        getResult(3, N-1);
        getResult(5, N-1);
        getResult(7, N-1);
        System.out.println(sb.toString());
    }

    static void getResult(int num, int n) {
        if(n == 0) {
            if(isPrime(num)) {
                sb.append(num);
                sb.append("\n");
            }
        }

        for(int i = 1; i < 10; i=i+2) {
            int k = num * 10 + i;
            if(isPrime(k)) {
                getResult(k, n-1);
            }
        }
    }

    static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
