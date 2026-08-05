class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl < tl) return "";
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0, left = 0;
        int formed = 0, required = need.size();
        Map<Character, Integer> window = new HashMap<>();
        for(int right = 0 ; right < s.length(); right++) {
            char sr = s.charAt(right);
            window.put(sr,window.getOrDefault(sr,0) + 1);
            if(need.containsKey(sr) && window.get(sr) == need.get(sr)) {
                formed++;
            }
            while (formed == required) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char lc = s.charAt(left);
                window.put(lc, window.get(lc)-1);
                if(window.get(lc) < need.getOrDefault(lc,0)) {
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
