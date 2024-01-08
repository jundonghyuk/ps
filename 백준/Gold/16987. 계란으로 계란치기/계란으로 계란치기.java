
import java.awt.*;
import java.util.Scanner;

public class Main {

    static int N;
    static Point[] points;
    static int ret;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(sc.nextInt(), sc.nextInt());
        }
        rec(0);
        System.out.println(ret);
    }

    public static void rec(int next) {
        if (next == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(points[i].x <= 0) {
                    cnt++;
                }
            }
            ret = Math.max(ret, cnt);
            return;
        }
        Point me = points[next];
        if (me.x <= 0) {
            rec(next + 1);
            return;
        }
        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (points[i].x <= 0 || next == i) {
                continue;
            }
            hit = true;
            Point you = points[i];
            int myDamage = you.y;
            int youDamage = me.y;

            me.x = me.x - myDamage;
            you.x = you.x - youDamage;
            rec(next + 1);
            me.x = me.x + myDamage;
            you.x = you.x + youDamage;
        }
        
        if (!hit) {
            rec(N);
        }
    }
}
