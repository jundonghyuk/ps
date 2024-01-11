import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
        19:10 ~
        1. 다리위에 있는 트럭을 1칸씩 전진시킨다.
        2. 다리를 통과한 트럭의 하중만큼 하중을 복구한다.
        3. 다리의 하중을 체크한다.
        4. 다음 트럭의 무게가 남은 하중보다 작거나 같으면 다리위에 둔다.(1칸전진)

 */
public class Main {

    static int n, w, l;
    static Queue<Integer> trucks = new LinkedList<>();
    static Queue<int[]> bridge = new LinkedList<>();
    static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        l = sc.nextInt();

        for (int i = 0; i < n; i++) {
            trucks.add(sc.nextInt());
        }
        Integer first = trucks.poll();
        bridge.add(new int[]{first, 1});
        l -= first;
        while (!bridge.isEmpty()) {
            time++;
            if (bridge.peek()[1] + w <= time) {
                l += bridge.poll()[0];
            }
            if (!trucks.isEmpty() && trucks.peek() <= l) {
                int truck = trucks.poll();
                l -=truck;
                bridge.add(new int[]{truck, time});
            }
        }

        System.out.println(time);
    }
}
