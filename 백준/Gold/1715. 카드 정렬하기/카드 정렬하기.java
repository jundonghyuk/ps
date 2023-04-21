import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int[] arr;
    static Deque<Integer> prev = new LinkedList<>();
    static Deque<Integer> next = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            prev.add(arr[i]);
        }

        long sum = 0;
        while (prev.size() > 1) {
            Deque<Integer> temp = new LinkedList<>();
            while (!prev.isEmpty()) {
                int count = 0;
                int partSum = 0;
                while (count != 2) {
                    if(!temp.isEmpty() && !prev.isEmpty()) {
                        if (prev.getFirst() < temp.getFirst()) {
                            partSum += prev.pollFirst();
                        } else {
                            partSum += temp.pollFirst();
                        }
                        count++;
                    } else {
                        if(temp.isEmpty()) {
                           partSum += prev.pollFirst();
                        } else {
                            partSum += temp.pollFirst();
                        }
                        count++;
                    }
                }
                sum += partSum;
                temp.addLast(partSum);
            }
            prev = new LinkedList<>(temp);
        }
        System.out.println(sum);
    }
}
