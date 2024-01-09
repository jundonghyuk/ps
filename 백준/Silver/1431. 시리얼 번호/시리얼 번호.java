
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static String[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() > s2.length()) {
                return 1;
            } else {
                int s1Sum = 0;
                int s2Sum = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if(s1.charAt(i) >= '1' && s1.charAt(i) <= '9') {
                        s1Sum += (s1.charAt(i) -'0');
                    }
                    if(s2.charAt(i) >= '1' && s2.charAt(i) <= '9') {
                        s2Sum += (s2.charAt(i) -'0');
                    }
                }
                if(s1Sum < s2Sum) {
                    return -1;
                } else if(s1Sum > s2Sum) {
                    return 1;
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
