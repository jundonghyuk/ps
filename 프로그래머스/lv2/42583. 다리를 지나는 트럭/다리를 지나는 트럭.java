
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//5:46~6:08
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int currentWeight = weight;
        Queue<Integer> restTrucks = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            restTrucks.add(truck_weights[i]);
        }

        Deque<Waiting> deque = new ArrayDeque<>();
        while (!restTrucks.isEmpty() || !deque.isEmpty()) {
            time++;
            while (!deque.isEmpty() && deque.peekFirst().time <= time) {
                // System.out.println(time + " 건넘 ");
                currentWeight += deque.pollFirst().weight;
            }
            if (!restTrucks.isEmpty() && restTrucks.peek() <= currentWeight) {
                // System.out.println(time + " 들어 ");
                Integer truck = restTrucks.poll();
                deque.add(new Waiting(time + bridge_length, truck));
                currentWeight -= truck;
            }
        }

        return time;
    }

    static class Waiting {
        int time;
        int weight;

        public Waiting(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
}
