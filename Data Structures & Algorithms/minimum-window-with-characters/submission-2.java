class Solution {

public boolean checkWinValid(Map<Character, Integer> targetMap, Map<Character, Integer> windowMap) {
        boolean winValid = true;
        for(Map.Entry<Character, Integer> e : targetMap.entrySet()) {
            if(!(windowMap.containsKey(e.getKey()) && windowMap.get(e.getKey()) >= e.getValue())) {
                winValid = false;
                break;
            }
        }
        return winValid;
    }

    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl < tl) return "";
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i = 0 ; i < tl; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int minWin = Integer.MAX_VALUE;
        int  minWinStart = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> winMap = new HashMap<>();
        while(end < sl) {
            boolean winValid;
            winMap.put(s.charAt(end) , winMap.getOrDefault(s.charAt(end),0)+1);
            winValid = checkWinValid(tMap, winMap);
            while(start <= end && winValid) {
                int len = end - start + 1;
                if(len < minWin) {
                    minWin = len;
                    minWinStart = start;
                }
                winMap.put(s.charAt(start), winMap.get(s.charAt(start))-1);
                if(winMap.get(s.charAt(start)) == 0) winMap.remove(s.charAt(start));
                start++;
                winValid = checkWinValid(tMap, winMap);
            }
            end++;
        }
       // System.out.println("Min Window :  " + minWin  + " Min Window start " + minWinStart);
        return minWin == Integer.MAX_VALUE ? "" : s.substring(minWinStart, minWinStart+minWin);
    }
}
