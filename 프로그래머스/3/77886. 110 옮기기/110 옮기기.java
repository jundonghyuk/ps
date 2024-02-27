import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        
        int len = s.length;
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            String str = s[i];
            Deque<Character> dq = new ArrayDeque<>();
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                dq.addLast(str.charAt(j));
                
                if (dq.size() >= 3) {
                   char first = dq.pollLast();
                   if(first != '0') {
                       dq.addLast(first);
                       continue;
                   }
                    
                   char second = dq.pollLast();
                   if(second != '1') {
                       dq.addLast(second);
                       dq.addLast(first);
                       continue;
                   }
                    
                   char third = dq.pollLast();
                   if(third != '1') {
                       dq.addLast(third);
                       dq.addLast(second);
                       dq.addLast(first);
                       continue;
                   }
                    cnt++;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            boolean insert = false;
            while (!dq.isEmpty()) {
                char ch = dq.pollLast();
                if (insert)  {
                    sb.append(ch);
                } else {
                    if (ch == '1') {
                        sb.append(ch);
                    } else {
                        for (int k = 0; k < cnt; k++) {
                            sb.append("011");
                            insert = true;
                        }
                        sb.append(ch);
                    }
                }
            }
            if(!insert) {
               for (int k = 0; k < cnt; k++) {
                    sb.append("011");
                    insert = true;
                }
            }
            ret[i] = sb.reverse().toString();
        }
        return ret;
    }
}