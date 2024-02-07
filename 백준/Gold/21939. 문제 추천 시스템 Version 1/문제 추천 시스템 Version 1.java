
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {

    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Problem> min = new PriorityQueue<>(
                (p1, p2) -> {
                    return p1.rating != p2.rating ? p1.rating - p2.rating : p1.num - p2.num;
                }
        );
        PriorityQueue<Problem> max = new PriorityQueue<>(
                (p1, p2) -> {
                    return p1.rating != p2.rating ? p2.rating - p1.rating : p2.num - p1.num;
                }
        );

        HashMap<Integer, Problem> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            Problem problem = new Problem(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            map.put(problem.num, problem);
            max.add(problem);
            min.add(problem);
        }

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            if (split[0].equals("solved")) {
                map.remove(Integer.parseInt(split[1]));
            } else if (split[0].equals("add")) {
                Problem problem = new Problem(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                map.put(problem.num, problem);
                max.add(problem);
                min.add(problem);
            } else {
                int ret = 0;
                if (split[1].equals("1")) {
                    while (!max.isEmpty()) {
                        Problem poll = max.poll();
                        if (map.containsKey(poll.num)) {
                            Problem problem = map.get(poll.num);
                            if (problem.equals(poll)) {
                                max.add(poll);
                                ret = problem.num;
                                break;
                            }
                        }
                    }
                } else {
                    while (!min.isEmpty()) {
                        Problem poll = min.poll();
                        if (map.containsKey(poll.num)) {
                            Problem problem = map.get(poll.num);
                            if (problem.equals(poll)) {
                                min.add(poll);
                                ret = problem.num;
                                break;
                            }
                        }
                    }
                }
                sb.append(ret + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Problem {
        int num;
        int rating;

        public Problem(int num, int rating) {
            this.num = num;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Problem problem = (Problem) o;
            return num == problem.num && rating == problem.rating;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, rating);
        }
    }
}
