
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int solution(int[] picks, String[] minerals) {
        int length = (int) Math.ceil(minerals.length / 5.0);
        List<Mine> arrange = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrange.add(new Mine());
        }
        int cnt = 0;
        for(int i = 0; i < picks.length; i++) {
            cnt += picks[i];
        }
        int boundary = Math.min(cnt * 5, minerals.length);

        for (int i = 0; i < boundary; i++) {
            arrange.get(i / 5).add(minerals[i]);
        }

        arrange.sort(Mine::compareTo);

        int idx = 0;
        int answer = 0;
        boolean noAxe = false;
        for (Mine mine : arrange) {
            while (true) {
                if (idx >= 3) {
                    noAxe = true;
                    break;
                }

                if (picks[idx] <= 0) {
                    idx++;
                } else {
                    picks[idx]--;
                    break;
                }
            }
            if(noAxe) {
                break;
            }
            answer += mine.remove(idx);
        }
        System.out.println(answer);
        return answer;
    }

    static class Mine implements Comparable<Mine> {
        int diamond;
        int iron;
        int stone;
        int labor;

        public void add(String mine) {
            if (mine.equals("diamond")) {
                diamond++;
                labor += 25;
            } else if (mine.equals("iron")) {
                iron++;
                labor += 5;
            } else {
                stone++;
                labor++;
            }
        }

        public int remove(int idx) {
            if (idx == 0) {
                return diamond + iron + stone;
            } else if (idx == 1) {
                return diamond * 5 + iron + stone;
            } else {
                return diamond * 25 + iron * 5 + stone;
            }
        }

        @Override
        public int compareTo(Mine o) {
            return o.labor - this.labor;
        }
    }
}
