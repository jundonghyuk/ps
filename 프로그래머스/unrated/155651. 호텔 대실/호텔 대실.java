import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static int solution(String[][] book_time) {
        int answer = 0;

        PriorityQueue<Room> queue = new PriorityQueue<>();
        List<Room_1> list = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            int start = change(book_time[i][0]);
            int end = change(book_time[i][1]);
            list.add(new Room_1(start, end));
        }

        Collections.sort(list);


        for (int i = 0; i < book_time.length; i++) {
            int startTime = list.get(i).startTime;
            int endTime = list.get(i).endTime;
            if (queue.isEmpty()) {
                Room room = new Room(startTime, endTime);
                queue.add(room);
                answer++;
            } else {
                Room peek = queue.peek();
                System.out.println("peek : " + peek.endTime + " " + "current: " + startTime);
                if (peek.endTime + 10 > startTime) {
                    Room room = new Room(startTime, endTime);
                    queue.add(room);
                    answer++;
                } else {
                    queue.poll();
                    Room room = new Room(startTime, endTime);
                    queue.add(room);
                }
            }
        }
        return answer;
    }

    static class Room implements Comparable<Room> {
        int startTime;
        int endTime;

        public Room(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            // 내가 크면 양수
            return endTime - o.endTime;
        }
    }

    static class Room_1 implements Comparable<Room_1> {
        int startTime;
        int endTime;

        public Room_1(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room_1 o) {
            // 내가 크면 양수
            if(startTime == o.startTime) {
                return endTime - o.endTime;
            }
            return startTime - o.startTime;
        }
    }

    public static int change(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
