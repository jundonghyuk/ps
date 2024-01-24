
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int l, p, v;
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (true) {
            l = sc.nextInt();
            p = sc.nextInt();
            v = sc.nextInt();
            if (l == 0 && p == 0 && v == 0) {
                break;
            }
            int q = v / p;
            q *= l;
            if(v % p !=0) {
                q += Math.min(l, v %p);
            }
            sb.append("Case " + t + ": ");
            sb.append(q);
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
    }
}
