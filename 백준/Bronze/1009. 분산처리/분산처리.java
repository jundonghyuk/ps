
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = 1;
            for (int i = 1; i <=m;i++) {
                k *= n;
                k %= 10;
            }
            if(k == 0) {
                System.out.println(10);
            } else {
                System.out.println(k);
            }
        }
    }
}
