
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int ret = Integer.MAX_VALUE;
        int cnt = 0;
        int prev = 0;
        for (int i = 0; i < line.length();i++) {
            if(prev == 0 && line.charAt(i) == '1') {
                cnt++;
            }
            prev = line.charAt(i)- '0';
        }
        ret = Math.min(cnt, ret);
        cnt = 0;
        prev = 1;
        for (int i = 0; i < line.length();i++) {
            if(prev == 1 && line.charAt(i) == '0') {
                cnt++;
            }
            prev = line.charAt(i)- '0';
        }
        ret = Math.min(ret, cnt);
        System.out.println(ret);
    }
}
