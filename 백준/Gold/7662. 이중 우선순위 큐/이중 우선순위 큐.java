
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    static int t, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> min = new PriorityQueue<>();
            PriorityQueue<Long> max = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] split = br.readLine().split(" ");
                if (split[0].equals("I")) {
                    min.add(Long.parseLong(split[1]));
                    max.add(Long.parseLong(split[1]));
                    map.put(Long.parseLong(split[1]), map.getOrDefault(Long.parseLong(split[1]), 0) + 1);
                } else {
                    PriorityQueue<Long> temp = split[1].equals("1") ? max : min;

                    while (!temp.isEmpty()) {
                        Long poll = temp.poll();
                        if (map.containsKey(poll)) {
                            Integer freq = map.get(poll);
                            if (freq == 1) {
                                map.remove(poll);
                            } else {
                                map.put(poll, freq - 1);
                            }
                            break;
                        }
                    }
                }
            }
            if(map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                long maxNum = 0;
                long minNum = 0;
                while(!max.isEmpty()) {
                    Long poll = max.poll();
                    if(map.containsKey(poll)) {
                        maxNum = poll;
                        break;
                    }
                }
                while(!min.isEmpty()) {
                    Long poll = min.poll();
                    if(map.containsKey(poll)) {
                        minNum = poll;
                        break;
                    }
                }
                System.out.println(maxNum + " " + minNum);
            }
        }
    }
}
